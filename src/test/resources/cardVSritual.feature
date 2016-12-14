# a full game with all possibilities to check game rules
  # we heal players when it's necessary to avoid game end before all tests performed

Feature: cardVSritual

  # Creature VS Ritual
  # Wolf VS Shield
  Scenario: WorlfVSShield

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Wolf"
    Given "Bob" plays a "Shield"

    Given "" wins the round

    # Creature VS Ritual
  # Bear VS Medicine
  Scenario: BearVSMedicine

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Bear"
    Given "Bob" plays a "Medicine"

    Given "" wins the round

    # Creature VS Ritual
  # Eagle VS Poison
  Scenario: EagleVSPoison

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Eagle"
    Given "Bob" plays a "Poison"

    Given "Bob" wins the round