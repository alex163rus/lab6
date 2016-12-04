/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Алексей
 */
public interface SockerPlayer {

    //фио:
    String getNickName();

    //Реутинг:
    Integer getPoints();

    //Лига игрока:
    League getLeague();

    //Страна происхождения
    Country getCountry();
}
