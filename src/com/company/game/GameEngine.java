package com.company.game;

import com.company.game.cards.MagicCard;
import com.company.game.cards.MonsterCard;
import com.company.game.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class GameEngine {

    private final Player[] players;
    private final RoundCounter roundCounter;

    public GameEngine(Player[] players, RoundCounter roundCounter) {
        this.players = players;
        this.roundCounter = roundCounter;
    }

    public boolean engage(MonsterCard monsterCard) {
        if (monsterCard == null) return false;

        attackPlayer(monsterCard);
        return true;
    }

    /**
     * @param magicCard
     * @implNote attackPlayer or healPlayer
     */
    public boolean engage(MagicCard magicCard) {
        if(magicCard == null) return false;
        return true;
    }

    /**
     * @param target
     * @param attacker
     * @return List[0] attacker card if it survives, List[1] defense cards if survives (filter card.calchp > 0)
     */
    public MonsterCard[] engage(MonsterCard target, MonsterCard attacker) {
        if(target == null || attacker == null) return new MonsterCard[]{null,null};

        return monsterOnMonster(target, attacker);
    }

    /**
     * @param activeCard
     * @param targets
     * @return List<MonsterCard> surviving cards
     * @implNote use private method
     */
    public List<MonsterCard> engage(MagicCard activeCard, List<MonsterCard> targets) {
        return new ArrayList<MonsterCard>();
    }


    /**
     * @return random int 1 - 6
     */
    private int throwDice() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }


    /**
     * @param monsterCard
     * @implNote attack player with card.attack / 2 rounded up
     */
    private void attackPlayer(MonsterCard monsterCard) {
        int damage = Math.max(0, (int) Math.ceil(monsterCard.getCalculatedAttack() / 2.0));
        players[roundCounter.getOpponentIndex()].addDamage(damage);
    }

    /**
     * @param magicCard
     * @implNote attack player with card.value
     */
    private void attackPlayer(MagicCard magicCard) {

    }

    /**
     * @param attacker
     * @param target
     * @return Card[0] target, Card[1] attacker
     */
    private MonsterCard[] monsterOnMonster(MonsterCard target, MonsterCard attacker) {
        int attackStat = attacker.getCalculatedAttack() + throwDice();
        int defendStat = target.getCalculatedDefense() + throwDice();

        int damage = attackStat - defendStat;
        if (damage > 0) {
            target.addDamage(damage);
        } else {
            attacker.addDamage(damage);
        }

        target = target.isAlive() ? target : null;
        attacker = attacker.isAlive() ? attacker : null;

        return new MonsterCard[]{target, attacker};
    }

    private MonsterCard magicOnMonster(MagicCard magicCard, MonsterCard monsterCard) {
        return null;
    }


}
