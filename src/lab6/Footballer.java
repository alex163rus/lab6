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
public class Footballer implements SockerPlayer {

    private String nickName;
    private Integer points;
    private Country country;
    private League league;

    public Footballer(String nickName, Integer points, Country country, League league) {
        this.nickName = nickName;
        this.points = points;
        this.country = country;
        this.league = league;
    }

    public Footballer(String nickName, Integer points, Country country) {
        this.nickName = nickName;
        this.points = points;
        this.country = country;
        this.league = null;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public Integer getPoints() {
        return points;
    }

    @Override
    public League getLeague() {
        return league;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "  Футболист:{" + "ФИО=" + nickName + ", Рейтинг=" + points + ", Страна=" + country + ", Лига=" + league + '}';
    }

}
