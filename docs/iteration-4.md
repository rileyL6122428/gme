*Framework Refactor* (DONE)
	*Get tests working*
	*Test Framework Refactor*
	*Get rid of spaghetti*
*Undo actions*
*level over*
*Flesh out attacking/ Unit up to this point*
*Flesh out demo level (1 unit vs another)*
*Flesh out teams*
*Design refactor (Turn, Interactable, Level is an interactable, and it generates turns until over,
	input dispatcher at a higher layer of abstraction)


##DESIGN

**Undo actions**
	* Extract Turn class
	* Make Turn an Interactable
	* add undo input to turn
	

**Design Refactor: 
	A Level Is an interactable, and it generates turns
	The Input Dispatcher should go at a higher layer of abstraction
	
**TODOS
	0. rangeOfEffect in action Interface
	1. movement action interface
	
	
	CONTINUE REDESIGN
		1. MAKE AN ACTING UNIT VIEW
		2. finish actionInterface stuff
	