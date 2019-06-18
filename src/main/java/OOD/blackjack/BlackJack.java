package OOD.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private List<Player> players;
    private Dealer dealer;
    private List<Card> cards;

    public BlackJack() {
        players = new ArrayList<>();
        dealer = new Dealer();
    }

    public void initCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void dealInitialCards() {
        for (Player player : players) {
            player.insertCard(dealNextCard());
        }

        dealer.insertCard(dealNextCard());

        for (Player player : players) {
            player.insertCard(dealNextCard());
        }

        dealer.insertCard(dealNextCard());
    }

    public Card dealNextCard() {
        Card card = cards.remove(0);
        return card;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void compareResult() {
        for (Player p : players) {
            if (dealer.largerThan(p)) {
                dealer.updateBets(p.getCurrentBets());
                p.lose();
            } else {
                dealer.updateBets(-p.getCurrentBets());
                p.win();
            }
        }
    }

    public String print() {
        String s = "";
        for (Player player : players) {
            s += "playerid: " + (player.getId() + 1) + " ;" + player.printPlayer();
        }
        return s;
    }


}
