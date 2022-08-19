package ru.msaggik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.msaggik.hibernate.model.Director;
import ru.msaggik.hibernate.model.Movie;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // подключение файла конфигурации hibernate.properties и классов Director и Movie
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);
        // создание сессии из configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // сессия
        Session session = sessionFactory.getCurrentSession();

        try {
            // начало транзакции
            session.beginTransaction();

//            // вывод фильмов выбранного режисёра:
//            // 1) вывод режисёра с id=1
//            Director director1 = session.get(Director.class, 1);
//            System.out.println(director1);
//            // 2) вывод фильмов данного режисёра
//            List<Movie> movies = director1.getMovies();
//            System.out.println(movies);
//
//            // определение режисёра фильма:
//            // 1) вывод фильма с id=11
//            Movie movie = session.get(Movie.class, 11);
//            System.out.println(movie);
//            // 2) вывод режисёра данного фильма
//            Director director = movie.getOwner();
//            System.out.println(director);

//            // добавление фильма:
//            // 1) вывод режисёра с id=6 владеющего добавляемым фильмом
//            Director director2 = session.get(Director.class, 6);
//            // 2) добавление нового фильма с данным режисёром
//            Movie movie2 = new Movie("Interstellar", 2014, director2);
//            // добавление пользователю нового товара (приведение в порядок кэша java)
//            director2.getMovies().add(movie2);
//            // 3) запись в БД нового фильма
//            session.save(movie2);

//            // создание нового режисёра с одним фильмом:
//            // 1) создание нового режисёра:
//            Director director3 = new Director("Zack Snyder", 56);
//            // 2) создание нового фильма данного режисёра
//            Movie movie3 = new Movie("Justice League", 2017, director3);
//            // добавление новому режисёру нового фильма (приведение в порядок кэша java)
//            director3.setMovies(new ArrayList<>(Collections.singleton(movie3)));
//            // 3) сохранение изменений в БД
//            session.save(director3);
//            session.save(movie3);

//            // удаление из БД фильмов у рефисёра с id=2:
//            // 1) вывод режисёра с id=2
//            Director director4 = session.get(Director.class, 2);
//            // 2) получение фильмов рефисёра с id=2
//            List<Movie> movies = director4.getMovies();
//            // 3) удаление из БД фильмов у рефисёра с id=2
//            for(Movie movie: movies)
//                session.remove(movie);
//            // очистка списка getMovies() (приведение в порядок кэша java)
//            director4.getMovies().clear();

//            // удаление данных режисёра с id=2 из БД
//            // 1) вывод режисёра с id=2
//            Director director5 = session.get(Director.class, 2);
//            // 2) удаление данных режисёра с id=2 из БД
//            session.remove(director5);
//            // 3) удаление данных режисёра с id=2 (приведение в порядок кэша java)
//            director5.getMovies().forEach(i -> i.setOwner(null));

//            // изменение режисёра у существующего фильма:
//            // 1) вывод из БД информации режисёра с id=3
//            Director director6 = session.get(Director.class, 3);
//            // 2) получение из БД информации фильма с id=1
//            Movie movie4 = session.get(Movie.class, 1);
//            // 3) пересъёмка фильма новым режисёром с id=3 и добавление этой информации в БД
//            movie4.setOwner(director6);
//            // обновление информации о последнем фильме  (приведение в порядок кэша java)
//            movie4.getOwner().getMovies().remove(movie4);
//            // добавление информации о новом фильме новому режисёру (приведение в порядок кэша java)
//            director6.getMovies().add(movie4);

            // закрытие транзакции
            session.getTransaction().commit();
        } finally {
            // закрытие сессии
            sessionFactory.close();
        }
    }
}