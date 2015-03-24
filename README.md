# olympiad-challenge
An interesting coding challenge from a computing olympiad a few years ago that I thought I'd take a stab at. I attached relevant figures for this problem in the root directory.

Problem text:

"Steve is a smart kid. He loves to demonstrate 3D ascii illustrations to his friends. Please write a program for him that generates a 3D ascii illustrations of Legos from the given input.
Assume all Lego pieces are cubes. Use a '+' for every corner of the lego, three '-' for an horizontal edge, one '|' for a vertical edge, and one '/' for a inward edge. Fill the empty space on with "."
(FB messed up the formatting, see figs in comment.)
A single lego piece would look like fig.1
Two pieces placed next to each other would look like fig.2
One placed on top of another would look like fig.3
One placed behind the other would look like fig.4
Now given two integers N and M on the first line with a NxM matrix following that represents how the Lego blocks are stacked, output the corresponding ascii illustration.
Example input:
3 4
2 2 1 2
2 2 1 1
3 2 1 2
Example output:
fig.5

