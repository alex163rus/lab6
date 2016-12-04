/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Алексей
 */
public class SockerLeague implements LeagueManager {

    private static ArrayList<SockerPlayer> players = new ArrayList<>();
    private League league;

    public SockerLeague(League league) {
        this.league = league;
    }

    @Override
    public void addPlayer(SockerPlayer player) {
        ((Footballer) player).setLeague(league);
        players.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player) {
        players.remove(player);
    }

    @Override
    public SockerPlayer getPlayer(String name) {
        for (SockerPlayer player : players) {
            if (player.getNickName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public SockerPlayer[] getAllPlayers() {
        return players.toArray(new SockerPlayer[players.size()]);
    }

    @Override
    public SockerPlayer[] getPlayers(League league) {
        ArrayList<SockerPlayer> playerInLeague = new ArrayList<>();
        for (SockerPlayer sockerPlayer : players) {
            if (sockerPlayer.getLeague() == league) {
                playerInLeague.add(sockerPlayer);
            }
        }
        return playerInLeague.toArray(new SockerPlayer[playerInLeague.size()]);
    }

    @Override
    public SockerPlayer[] getPlayers(Country country) {
        ArrayList<SockerPlayer> playerInCountry = new ArrayList<>();
        for (SockerPlayer sockerPlayer : players) {
            if (sockerPlayer.getCountry() == country) {
                playerInCountry.add(sockerPlayer);
            }
        }
        return playerInCountry.toArray(new SockerPlayer[playerInCountry.size()]);
    }

    @Override
    public void addPoints(String name, int points) {
        for (SockerPlayer player : players) {
            if (player.getNickName().equals(name)) {
                ((Footballer) player).addPoints(points);
                return;
            }
        }
    }

    public SockerPlayer[] getPlayersSortPoint(Country country) {
        ArrayList<SockerPlayer> playersThisCountry = new ArrayList<>(Arrays.asList(getPlayers(country)));
        Collections.sort(playersThisCountry, new Comparator<SockerPlayer>() {
            @Override
            public int compare(SockerPlayer sockerPlayer1, SockerPlayer sockerPlayer2) {
                return sockerPlayer1.getPoints().compareTo(sockerPlayer2.getPoints());
            }
        }.reversed());
        return playersThisCountry.toArray(new SockerPlayer[playersThisCountry.size()]);
    }

    public SockerPlayer[] getPlayersSortPoint() {
        ArrayList<SockerPlayer> playersThisLeage = new ArrayList<>(Arrays.asList(getPlayers(league)));
        Collections.sort(playersThisLeage, new Comparator<SockerPlayer>() {
            @Override
            public int compare(SockerPlayer sockerPlayer1, SockerPlayer sockerPlayer2) {
                return sockerPlayer1.getPoints().compareTo(sockerPlayer2.getPoints());
            }
        }.reversed());
        return playersThisLeage.toArray(new SockerPlayer[playersThisLeage.size()]);
    }

    public League getLeague() {
        return league;
    }

    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        for (SockerPlayer player : players) {
            if (player.getLeague() == league) {
                br.append(player + "\n");
            }
        }
        return "Лига=" + league + ", игроки:{\n" + br.toString() + '}';
    }

}
