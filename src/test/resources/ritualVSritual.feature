# a full game with all possibilities to check game rules
  # we heal players when it's necessary to avoid game end before all tests performed

Feature: cardVSritual

  # Ritual VS Ritual
  # Wolf VS Shield
  Scenario: ShieldVSShield

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Shield"
    Given "Bob" plays a "Shield"

    Given "" wins the round

    # Poison VS Shield
  Scenario: PoisonVSShield

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Poison"
    Given "Bob" plays a "Shield"

    Given "" wins the round

    # Ritual VS Ritual
  # Medicine VS Poison
  Scenario: MedicineVSPoison

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Medicine"
    Given "Bob" plays a "Poison"

    Given "" wins the round

   # Medicine VS Shield
  Scenario: MedicineVSShield

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points

    Given "Alice" plays a "Medicine"
    Given "Bob" plays a "Shield"

    Given "Alice" wins the round