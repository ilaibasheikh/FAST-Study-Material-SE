public class language {
    public String language;

    public language() {
        language = "JAVA";
    }

    public language(String lang){
        language = lang;
    }


    void display(){
        System.out.println(language);
    }


    public static void main(String[] args) {
        language l1 = new language();
        language l2 = new language("C");

        l1.display();
        l2.display();
    }

}