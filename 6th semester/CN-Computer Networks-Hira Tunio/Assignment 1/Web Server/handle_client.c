#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>
#include <ws2tcpip.h>

#include "server.h"

void handle_client(int client_sock) {
    char buffer[8192], method[16], url[256], protocol[16], host[128], path[256];
    int remote_sock, port = 80;

    int received = recv(client_sock, buffer, sizeof(buffer), 0);
    if (received < 0) {
        perror("Recv failed");
        closesocket(client_sock);
        return;
    }

    if (sscanf(buffer, "%s %s %s", method, url, protocol) != 3) {
        send(client_sock, "HTTP/1.0 400 Bad Request\r\n\r\n", 26, 0);
        closesocket(client_sock);
        return;
    }

    if (strcmp(method, "GET") != 0) {
        send(client_sock, "HTTP/1.0 501 Not Implemented\r\n\r\n", 32, 0);
        closesocket(client_sock);
        return;
    }

    sscanf(url, "http://%127[^/]/%255[^\n]", host, path);
printf("Parsed Host: %s\n", host);
printf("Parsed Path: %s\n", path);

    printf("Forwarding request to %s\n", host);

    struct sockaddr_in remote_addr;
    struct hostent *server = gethostbyname(host);
    if (server == NULL) {
        send(client_sock, "HTTP/1.0 404 Not Found\r\n\r\n", 26, 0);
        closesocket(client_sock);
        return;
    }

    remote_sock = socket(AF_INET, SOCK_STREAM, 0);
    remote_addr.sin_family = AF_INET;
    remote_addr.sin_port = htons(port);
    memcpy(&remote_addr.sin_addr.s_addr, server->h_addr, server->h_length);

    if (connect(remote_sock, (struct sockaddr *)&remote_addr, sizeof(remote_addr)) < 0) {
        perror("Connection failed");
        send(client_sock, "HTTP/1.0 502 Bad Gateway\r\n\r\n", 28, 0);
        closesocket(client_sock);
        return;
    }

    char request[1024];
    snprintf(request, sizeof(request), "GET /%s HTTP/1.0\r\nHost: %s\r\n\r\n", path, host);
    send(remote_sock, request, strlen(request), 0);

    int bytes;
    while ((bytes = recv(remote_sock, buffer, sizeof(buffer), 0)) > 0) {
        send(client_sock, buffer, bytes, 0);
    }

    closesocket(remote_sock);
    closesocket(client_sock);
}
