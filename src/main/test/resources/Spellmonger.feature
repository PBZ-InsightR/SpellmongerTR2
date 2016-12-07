Feature: Spellmonger
  Game of cards for two players
Cards:
  Creatures: eagle (1 point), wolf (2 points), bear (3 points)
  Ritual: poison (-3 health points), shield, medicine (+3 life points)

Deck of 42 cards, composed of 12 eagle cards , 10 wolf cards, 10 bear cards, 2 poison cards, 5 shield cards and 3 medicine cards

  At the beginning, each player has 20 health points.
  All cards of deck are face down.
  We mix the deck, distribute cards (one by one and always face down) to each players.
  => each player receives 3 cards, called the player's "hand";
  => the rest of cards is named "deck"

  Each player can see his/her hand

  At each round of the game:
  each player simultaneously play 1 card of his/her choice of his/her hand

If the 2 played cards are creatures, but not the same creature (for example: a wolf against a bear),
  the player who plays the weakest card loses health points equal to the difference of cards' health points
  (for example: difference = bear - wolf = 3 - 2 = 1 so the player who plays wolf card loses 1 health point)
  If the 2 played care are the same creature, creature kills each other and neither player loses any health point.

If 2 played cards are rituals,
  player who plays a medicine card gains 3 health points,
  his/her opponent who plays a poison card loses 3 health points, unless this opponent plays a shield card,
  in this case, nothing happens to the player who plays the shield card.

If players plays a creature and a ritual cards
  - medicine card VS creature card
  the player who plays a medicine card gains 3 health points, but also loses as many health points as the creature's points played by his/her opponent,
  nothing happens to the player who plays the creature card
  - poison card VS creature card
  the opponent of the player who plays a poison card loses 3 health points;
  the player who plays the poison card loses as many health points as the creature's points played by his/her opponent
  - shield card VS creature card
  nothing happens to both players
  they put played cards back in common discard deck, face up cards in order to not confuse deck and common discard deck

When there is no more card in players' hand, (at the beginning, there are 3, then 2 then 1 face up card as game is going on),
  each player receives 3 new cards from the deck

  when there is no more cards in the deck, players mix and upturn the common discard deck to create a new deck
  they distribute cards to each player like at the beginning of the game.

  End of the game:
  If a player don't have any health points anymore, he/she loses, his/her opponent wins in case he/she still has health points
  If both players don't have health points anymore in the same round, there is no winner