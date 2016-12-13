# a full game with all possibilities to check game rules
  # we heal players when it's necessary to avoid game end before all tests performed

Feature: cardVScard

  # Creature VS Creature - <> Creatures
  # Wolf VS Eagle
  Scenario: WorlfVSEagle

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Wolf"
    Given "Bob" plays a "Eagle"

    Given "Alice" wins the round