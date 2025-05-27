#include <stdio.h>
#include <stdlib.h>
#include <winsock2.h>
#include "server.h"

#pragma comment(lib, "ws2_32.lib")  

int main() {
    WSADATA wsa;
    if (WSAStartup(MAKEWORD(2,2), &wsa) != 0) {
        printf("Winsock initialization failed\n");
        return 1;
    }

    int port;
    printf("Enter the port number to run the server on: ");
    scanf("%d", &port);

    int server_fd = start_server(port);
    struct sockaddr_in client_addr;
    int addr_size = sizeof(client_addr);

    while (1) {
        int client_sock = accept(server_fd, (struct sockaddr *)&client_addr, &addr_size);
        if (client_sock < 0) {
            perror("Accept failed");
            continue;
        }
        handle_client(client_sock);
    }

    closesocket(server_fd);
    WSACleanup();  
    return 0;
}
