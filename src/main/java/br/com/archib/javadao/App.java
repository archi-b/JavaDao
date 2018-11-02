package br.com.archib.javadao;

import br.com.archib.javadao.dao.DBContext;
import br.com.archib.javadao.model.Movie;
import br.com.archib.javadao.service.MovieService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class App {

    public static void main(String... args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------ Menu ---------------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create new movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");

        int choice = scanner.nextInt();

        MovieService service = (MovieService)new DBContext().get("movieService");

        switch (choice) {
            case 1:
                List<Movie> list = service.findAll();
                System.out.println(String.format("1 - List %s", list.toString()));
                break;
            case 2:
                System.out.println("2 - Insert");
                //new MovieDao().insert(new Movie("Marta"));
                break;
            case 3:
                break;
            case 4:
                System.out.println("2 - Insert");
                //new MovieDao().delete(new Movie("Marta"));
                break;
            default:
                break;
        }

    }

}
