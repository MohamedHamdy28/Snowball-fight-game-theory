# Snowball-fight-game-theory
This is a simulation for an agent that play a snowball fight against other agent. 

## Problem Description
Snowball fight is a physical game primarily played during winter when there is sufficient snowfall. Usually,
players are dividing into teams and attack opponents or their fields. In this simulation, we will create a
model of the snowball game environment in order to understand the nature of this game.
The environment where players play the snowball game is three territorial regions which we will helpfully
entitled as A, B, and C fields. Fields A and B contain one player on each side. The field C does NOT contain
any players and should be considered as a hot field where snowballs automatically melt and disappear.
The players cannot change their positions and should shot snowballs from the field they are located on.
You may assume that for both A and B fields the initial number of snowballs is N=100. Each A and B fields
have a single Snowball Generating Machine (SGM). Because of those machines each imaginary minute the
number of snowballs N increases by 1 for both fields.
Both players are using special Snowball Cannons (SC) able to shoot snowballs. Assume that shooting does
not melt or destroy snowballs. The players can use Cannons at most once per minute to opponent’s field
and at most once per minute to hot field (totally at most twice, assume it as sequential shots, where shot
to opponent’s field happens firstly). Each shot can contain 1 snowball or more. Not shooting is also
allowed and requires 0 to be returned by a proper method. If no shooting happened to opponent’s and
hot fields, then it is assumed that during this minute shooting didn’t happen. If SC was used once or twice
per minute, then it is assumed as a presence of shooting during this minute. However, the shooting history
affects the maximum number of snowballs shoot for the next minutes. The maximum number of
snowballs shoot by cannon per minute (together for both shots) is defined by equation
𝑓(𝑥) = (15 × 𝑒!) / (15 + 𝑒!)
where 𝑥 is the number of minutes passed after the previous shot (presence of shooting). This equation is
not affected by the number of snowballs shoot during the last shots. Cannon is also limited by the number
of snowballs present in the field.
Assume that initially both SC are having history of shooting during the previous minute. After 60 minutes
(also called rounds), the number of snowballs left in your field has to be minimized for maximizing your
payoff.

## Task

You will create an agent for the Snowball player, and test your agent against others. Your code should be
written in Java, and you need to create your agent (public class with public default constructor)
implementing the interface as seen below. The interface has:

1. a void method reset() which will be called in order to ‘reset’ the agent before the match with each player containing 60 rounds (imaginary minutes)
2. an integer method shootToOpponentField() returning the number of snowballs your agent will shoot to the opponent’s field given the last opponent’s shot to your field (0 – if this is the first round), and the number of minutes passed after your previous shot (0 – if this is the first round). The shootToOpponentField() method returns at least 0 snowballs
3. an integer method shootToHotField() returning the number of snowballs your agent will shoot to the hot field given the last opponent’s shot to your field (0 – if this is the first round), and the number of minutes passed after your previous shot (0 – if this is the first round). The shootToHotField() method returns at least 0 snowballs.
4. getEmail() method returning String with your Innopolis email
5. an integer default method maxSnowballsPerMinute() returning the maximum number of snowballs which can be shot by a player per minute based on the number of minutes passed after the previous shot
