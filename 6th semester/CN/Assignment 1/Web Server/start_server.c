#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <winsock2.h>
#include "server.h"
#include <ws2tcpip.h>
#pragma comment(lib, "ws2_32.lib")

#define MAX_CONNECTIONS 100

int start_server(int port) {
    int server_fd;
    struct sockaddr_in server_addr;

    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
        perror("Socket failed");
        exit(EXIT_FAILURE);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(port);
    


    if (bind(server_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("Bind failed");
        exit(EXIT_FAILURE);
    }

    if (listen(server_fd, MAX_CONNECTIONS) < 0) {
        perror("Listen failed");
        exit(EXIT_FAILURE);
    }

    printf("Proxy server listening on port %d...\n", port);
    return server_fd;
}
