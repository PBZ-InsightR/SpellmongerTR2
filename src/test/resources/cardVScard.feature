# a full game with all possibilities to check game rules
  # we heal players when it's necessary to avoid game end before all tests performed

Feature: Spellmonger Card Rules Check

  # Creature VS Creature - <> Creatures
  # Wolf VS Eagle
  Scenario: WorlfVSEagle # cucumber/regex.feature:9

    # The party begins
    Given "Alice" and "Bob" enter the game, receive 3 cards and 20 life points
    CucumberSteps.i_have_a_X_cucumber_step()

    When "Alice" plays a "Wolf"
      And "Bob" plays a "Eagle"

    Then "Alice" wins the round