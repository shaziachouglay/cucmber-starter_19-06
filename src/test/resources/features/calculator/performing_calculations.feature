
Feature: Perform Calculations

  As a primary school maths student
  I want to perform various calculations
  So that I can practice my maths skills

  Background:
    Given Matt a maths student has opened the calculator

    @sc
  Scenario Outline: Perform mathematical calculations
    When Matt performs the following calculation:
      | Left Operand   | Operator   | Right Operand   |
      | <Left Operand> | <Operator> | <Right Operand> |
    Then he should see a result of "<Result>"

    Examples: Additions and subtractions
      | Left Operand | Operator | Right Operand | Result |
      | 1            | +        | 2             | 3      |
      | 12           | +        | 34            | 46     |
      | 12           | -        | 5             | 7      |
      | 12           | -        | 34            | -22    |

    Examples: Multiplications and divisions
      | Left Operand | Operator | Right Operand | Result |
      | 1            | *        | 2             | 2      |
      | 2            | *        | 4             | 8      |
      | 10           | /        | 4             | 2.5    |