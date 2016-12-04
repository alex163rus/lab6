/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Алексей
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SockerLeague[] sockerLeagues = new SockerLeague[League.values().length];
        for (int i = 0; i < sockerLeagues.length; i++) {//Создание всех лиг, перечисленных в League
            sockerLeagues[i] = new SockerLeague(League.values()[i]);
        }

        Random r = new Random();
        final int nCountFootballer = r.nextInt(12) + 5;
        for (int i = 0; i < nCountFootballer; i++) {
            sockerLeagues[r.nextInt(sockerLeagues.length)].
                    addPlayer(new Footballer(Surname.values()[r.nextInt(Surname.values().length)].toString()//Установка случайной фамилии из Surname
                            + " " + Name.values()[r.nextInt(Name.values().length)].toString()//Установка случайного имени из Name
                            + " " + Patronymic.values()[r.nextInt(Patronymic.values().length)].toString(),//Установка случайного отчества из Patronymic
                            r.nextInt(100),//случайный рейтинг
                            Country.values()[r.nextInt(Country.values().length)]));//Случайная страна из Country
        }

        for (SockerLeague sockerLeague : sockerLeagues) {//вывод сгенерированных игроков
            if (sockerLeague.getPlayers(sockerLeague.getLeague()).length == 0) {
                continue;
            }
            System.out.println(sockerLeague);
        }
        System.out.println("--------------------------------------------");

        SockerPlayer[] sortPlayers = null;//массив для отсортированных результатов
        System.out.println("Сортировка по СТРАНАМ:");
        for (Country country : Country.values()) {//перебор всех стран
            sortPlayers = sockerLeagues[0].getPlayersSortPoint(country);// сортировка по стране и рейтингу
            if (sortPlayers.length == 0) {
                continue;
            }
            System.out.println("Страна " + country + ": ");
            for (SockerPlayer sortPlayer : sortPlayers) {//вывод игроков из страны, отсортированных по рейтингу 
                System.out.println(sortPlayer);
            }
        }

        System.out.println("-----------------------------------------\nСортировка по ЛИГАМ:");
        for (SockerLeague sockerLeague : sockerLeagues) {//перебор всех лиг
            sortPlayers = sockerLeague.getPlayersSortPoint();// сортировка по лиге и рейтингу
            if (sortPlayers.length == 0) {
                continue;
            }
            System.out.println("Лига " + sockerLeague.getLeague() + ":{");
            for (SockerPlayer sortPlayer : sortPlayers) {
                System.out.println(sortPlayer);//вывод игроков из лиги, отсортированных по рейтингу 
            }
            System.out.println("}");
        }
    }
}
