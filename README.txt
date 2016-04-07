Messo in IVY_HOME
	* ivy-settings
	* local-properties

E' richiesto nella root del progetto:
	* dependencies.xml

E' richiesto che siano settate le seguenti variabili d'ambiente:
	ANT_ARGS = -Divy.install.dir="%IVY_HOME%" -lib "%IVY_HOME%"
	ANT_OPTS = -Divy.install.dir="%IVY_HOME%"
