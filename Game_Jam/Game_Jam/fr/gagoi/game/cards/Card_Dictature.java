package fr.gagoi.game.cards;

public class Card_Dictature extends Card {	

	@Override
	public String getImage() {
		return "/cartes/lois/dictature.jpg";
	}

	@Override
	public void onUse() {
		//PLUS DE PERTE DE POPULARITE PENDANT 10 TOURS.
	}

}
