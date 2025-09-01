#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_COURSES 5

struct course {
    char code[15];
    char name[50];
};

struct student {
    int id;
    char name[50];
    struct course courses[MAX_COURSES];
    int num_courses;
};

struct course course_list[] = {
   {"NS1001", "Physics"},
    {"CL1000", "ICT"},
    {"SS1004", "English "},
    {"CS1002", "Programming "},
    {"MT1003", "Calculus "}
};

void print_menu() {
    printf("\n\n");
    printf("1. Register Courses\n");
    printf("2. View Registered Courses\n");
    printf("3. Exit\n");
    printf("Enter your choice: ");
}

void register_courses(struct student *s) {
    int i, j;
    printf("\nEnter your name: ");
    scanf("%s", s->name);
    printf("Enter your id (the last four digits of your student id): ");
    scanf("%d", &(s->id));
    printf("Enter the number of courses you want to register (up to %d): ", MAX_COURSES);
    scanf("%d", &(s->num_courses));
    printf("\n\nPhysics: NS1001\nCalculus: MT1003\nICT: CL1000\nProgramming: CS1002\nEnglish: SS1004\n\n");
    printf("Enter the course codes : ");
    for (i = 0; i < s->num_courses; i++) {
        scanf("%s", s->courses[i].code);
        for (j = 0; j < MAX_COURSES; j++) {
            if (strcmp(s->courses[i].code, course_list[j].code) == 0) {
                strcpy(s->courses[i].name, course_list[j].name);
                break;
            }
        }
    }

    // Writing student record to file
    FILE *fp;
    fp = fopen("courses.txt", "a");
    fprintf(fp, "%d %s ", s->id, s->name);
    for (i = 0; i < s->num_courses; i++) {
        fprintf(fp, "%s:%s ", s->courses[i].code, s->courses[i].name);
    }
    fprintf(fp, "\n");
    fclose(fp);
}

void view_courses(int id) {
    char line[100];
    int found = 0;
    FILE *fp;
    fp = fopen("courses.txt", "r");
    while (fgets(line, 100, fp) != NULL) {
        int file_id;
        sscanf(line, "%d", &file_id);
        if (file_id == id) {
            found = 1;
            printf("\n%s", line);
        }
    }
    fclose(fp);
    if (!found) {
        printf("\nRecord not found for id %d", id);
    }
}

int main() {
    int choice;
    struct student s;
    while (1) {
        print_menu();
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                register_courses(&s);
                break;
            case 2:
                printf("\nEnter your id: ");
                scanf("%d", &(s.id));
                view_courses(s.id);
                break;
            case 3:
                exit(0);
            default:
                printf("\nInvalid choice");
        }
    }
    return 0;
}