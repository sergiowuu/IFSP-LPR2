/* 
 * Sergio WU CB3025691
 * Jackson de Lima Gregorio CB3013189
*/

public class ex01 {

    public class Author {
        private String name;
        private String email;
        private char gender;
        private int id;
    
        public Author(String name, String email, char gender, int id) {
            this.name = name;
            this.email = email;
            this.gender = gender;
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public char getGender() {
            return gender;
        }
    
        public int getId() {
            return id;
        }
    
        @Override
        public String toString() {
            return "Author[name=" + name + ",email=" + email + ",gender=" + gender + ",id=" + id + "]";
        }
    }

    public class Book {
        private String name;
        private Author[] authors;
        private double price;
        private int qty;
        private int id;
    
        public Book(String name, Author[] authors, double price, int qty, int id) {
            this.name = name;
            this.authors = authors;
            this.price = price;
            this.qty = qty;
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public Author[] getAuthors() {
            return authors;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public int getQty() {
            return qty;
        }
    
        public void setQty(int qty) {
            this.qty = qty;
        }
    
        public int getId() {
            return id;
        }
    
        @Override
        public String toString() {
            StringBuilder authorsStr = new StringBuilder();
            for (Author author : authors) {
                authorsStr.append(author.toString()).append(",");
            }
            // Remove the last comma
            if (authorsStr.length() > 0) {
                authorsStr.setLength(authorsStr.length() - 1);
            }
            return "Book[name=" + name + ",authors={" + authorsStr.toString() + "},price=" + price + ",qty=" + qty + ",id=" + id + "]";
        }
    }
}

class TestAuthor {
    public static void main(String[] args) {
        
        ex01.Author author = new ex01().new Author("Wellington Tuller", "tulermoraes@yaho.com", 'm', 1);

        System.out.println(author.toString());
        author.setEmail("newEmail@example.com");
        System.out.println("Email atualizado: " + author.getEmail());

        System.out.println("Nome: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Gênero: " + author.getGender());
        System.out.println("ID: " + author.getId());
    }
}

class TestBook {
    public static void main(String[] args) {
        // Crie e aloque o array de autores.
        ex01.Author[] authors = new ex01.Author[2];
        authors[0] = new ex01().new Author("Autor 01", "autor01@.com.br", 'm', 1);
        authors[1] = new ex01().new Author("Autor 02", "autor02@com.br", 'f', 2);

        // Declarar e alocar a instância de um book.
        ex01.Book testeBook = new ex01().new Book("Java for Dummy", authors, 19.99, 99, 1);
        System.out.println(testeBook); // toString()
    }
}
