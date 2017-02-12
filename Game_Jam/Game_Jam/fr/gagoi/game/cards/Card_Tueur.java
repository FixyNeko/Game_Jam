package fr.gagoi.game.cards;

public class Card_Tueur extends Card {

	@Override
	public String getImage() {
		return "/cartes/unites/tueur.jpg";
	}

	@Override
	public void onUse() {
		System.out.println("C'est win !");
	}

}
