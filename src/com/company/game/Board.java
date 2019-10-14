package com.company.game;

import com.company.game.cards.Card;
import com.company.game.cards.MagicCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private final List[] monsterPiles;
    private final GameEngine gameEngine;
    private final RoundCounter roundCounter;


    public Board(RoundCounter roundCounter) {
        monsterPiles = new List[]{new ArrayList<Card>(), new ArrayList<Card>()};
        gameEngine = new GameEngine();
        this.roundCounter = roundCounter;
    }
    public List<String> getMonsterPiles(int player) {
        return null;
    }

    public boolean placeCardOnBoard(Card card) {
        return false;
    }

    public boolean placeCardOnCardWithId(Card card, int id) {
        return false;
    }

    public boolean attackMonsterWithMonster(int defender, int attacker) {
        return false;
    }

    public boolean useMagicOnMonster(MagicCard magicCard, int monsterCard) {
        return false;
    }

    public boolean useMagic(MagicCard magicCard) {
        return false;
    }
}
