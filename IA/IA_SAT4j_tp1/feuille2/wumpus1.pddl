(define (domain wumpus-1)
  (:requirements :strips) 

  (:predicates
   (adj ?square-1 ?square-2)
   (pit ?square)
   (at ?what ?square)
   (have ?who ?what)
   (dead ?who))
  (:action shoot
    :parameters (?who ?where ?arrow ?victim ?where-victim)
    :precondition (and (have ?who ?arrow)
		       (at ?who ?where)
		       (at ?victim ?where-victim)
		       (adj ?where ?where-victim))
    :effect (and (dead ?victim)
		 (not (at ?victim ?where-victim))
		 (not (have ?who ?arrow)))
    )
  (:action take
    :parameters (?who ?what ?where)
    :precondition (and (at ?who ?where)
		       (at ?what ?where))
    :effect (and (have ?who ?what)
		 (not (at ?what ?where)))
    )
 (:action move
    :parameters (?who ?from ?to)
    :precondition (and (adj ?from ?to)
		       (not (pit ?to))
		       (at ?who ?from))
    :effect (and (not (at ?who ?from))
		 (at ?who ?to))
    )

)

