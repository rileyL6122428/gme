###Necessary
* Get basic attacks working
	0. make 1 and 2 dimensional grid classes (DONE) 
	0. make attack options grid
		- testing and refactoring checkpoint
	0. make attack grid (insert into input dispatcher)
		- testing and refactoring checkpoint
	1. make attack view
	2. get moving in place working again
		- testing and refactoring checkpoint

	
###IF time allows
* Make teams and basic AI
* Make Healing Action 
* Interface Navigator framework (rework input dispatcher)


# Right Now
	- implement placing attacks
	- refactor two dimensional grid and rectangular Grid
	- implement undoing action (with decision tree)

#DESIGN PLANS

GRID HIERACHY

Grid Interface -> TwoDimensionalGrid -> OneDimensionalGrid
						| 						|
					PlayingGrid            ActionMenu