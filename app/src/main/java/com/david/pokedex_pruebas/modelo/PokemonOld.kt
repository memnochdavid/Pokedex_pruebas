package com.david.pokedex_pruebas.modelo

import com.david.pokedex_pruebas.R

data class PokemonOld(
    var foto: Int=0,
    var name: String="",
    var desc: String="",
    var tipo: List<Int> = listOf()
)

var listaPoke : List<PokemonOld> = listOf(
    PokemonOld(R.drawable.bulbasaur01, "Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.ivisaur01, "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.venusaur01, "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.charmander01, "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.charmeleon01, "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.charizard01, "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", listOf(R.drawable.fuego, R.drawable.volador)),
    PokemonOld(R.drawable.squirtle01, "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.wartortle01, "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.blastoise01, "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.caterpie01, "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", listOf(R.drawable.bicho)),
    PokemonOld(R.drawable.metapod01, "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", listOf(R.drawable.bicho)),
    PokemonOld(R.drawable.butterfree01, "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.", listOf(R.drawable.bicho, R.drawable.volador)),
    PokemonOld(R.drawable.weedle01, "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", listOf(R.drawable.bicho, R.drawable.veneno)),
    PokemonOld(R.drawable.kakuna01, "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", listOf(R.drawable.bicho, R.drawable.veneno)),
    PokemonOld(R.drawable.beedril01, "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", listOf(R.drawable.bicho, R.drawable.veneno)),
    PokemonOld(R.drawable.pidgey, "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.pidgeotto, "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.pidgeot, "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.rattata, "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.raticate, "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.spearow, "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.fearow, "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.ekans, "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.arbok, "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.pikachu, "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.raichu, "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.sandshrew, "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.sandslash, "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.nidoranf, "Nidoran♀", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.nidorina, "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.nidoqueen, "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", listOf(R.drawable.veneno, R.drawable.tierra)),
    PokemonOld(R.drawable.nidoranm, "Nidoran♂", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.nidorino, "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.nidoking, "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", listOf(R.drawable.veneno, R.drawable.tierra)),
    PokemonOld(R.drawable.clefairy, "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", listOf(R.drawable.hada)),
    PokemonOld(R.drawable.clefable, "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", listOf(R.drawable.hada)),
    PokemonOld(R.drawable.vulpix, "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.ninetales, "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.jigglypuff, "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", listOf(R.drawable.normal, R.drawable.hada)),
    PokemonOld(R.drawable.wigglytuff, "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", listOf(R.drawable.normal, R.drawable.hada)),
    PokemonOld(R.drawable.zubat, "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", listOf(R.drawable.veneno, R.drawable.volador)),
    PokemonOld(R.drawable.golbat, "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", listOf(R.drawable.veneno, R.drawable.volador)),
    PokemonOld(R.drawable.oddish, "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.gloom, "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.vileplume, "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.paras, "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", listOf(R.drawable.bicho, R.drawable.planta)),
    PokemonOld(R.drawable.parasect, "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", listOf(R.drawable.bicho, R.drawable.planta)),
    PokemonOld(R.drawable.venonat, "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", listOf(R.drawable.bicho, R.drawable.veneno)),
    PokemonOld(R.drawable.venomoth, "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", listOf(R.drawable.bicho, R.drawable.veneno)),
    PokemonOld(R.drawable.diglett, "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.dugtrio, "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.meowth, "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.persian, "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.psyduck, "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.golduck, "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.mankey, "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.primeape, "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.growlithe, "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.arcanine, "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.poliwag, "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.poliwhirl, "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.poliwrath, "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", listOf(R.drawable.agua, R.drawable.lucha)),
    PokemonOld(R.drawable.abra, "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.kadabra, "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.alakazam, "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.machop, "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.machoke, "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.machamp, "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.bellsprout, "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.weepinbell, "Weepinbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.victreebel, "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", listOf(R.drawable.planta, R.drawable.veneno)),
    PokemonOld(R.drawable.tentacool, "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", listOf(R.drawable.agua, R.drawable.veneno)),
    PokemonOld(R.drawable.tentacruel, "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", listOf(R.drawable.agua, R.drawable.veneno)),
    PokemonOld(R.drawable.geodude, "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", listOf(R.drawable.roca, R.drawable.tierra)),
    PokemonOld(R.drawable.graveler, "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", listOf(R.drawable.roca, R.drawable.tierra)),
    PokemonOld(R.drawable.golem, "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", listOf(R.drawable.roca, R.drawable.tierra)),
    PokemonOld(R.drawable.ponyta, "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.rapidash, "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.slowpoke, "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", listOf(R.drawable.agua, R.drawable.psiquico)),
    PokemonOld(R.drawable.slowbro, "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", listOf(R.drawable.agua, R.drawable.psiquico)),
    PokemonOld(R.drawable.magnemite, "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", listOf(R.drawable.electrico, R.drawable.acero)),
    PokemonOld(R.drawable.magneton, "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", listOf(R.drawable.electrico, R.drawable.acero)),
    PokemonOld(R.drawable.farfetchd, "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.doduo, "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.dodrio, "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", listOf(R.drawable.normal, R.drawable.volador)),
    PokemonOld(R.drawable.seel, "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.dewgong, "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", listOf(R.drawable.agua, R.drawable.hielo)),
    PokemonOld(R.drawable.grimer, "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.muk, "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.shellder, "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.cloyster, "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", listOf(R.drawable.agua, R.drawable.hielo)),
    PokemonOld(R.drawable.gastly, "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", listOf(R.drawable.fantasma, R.drawable.veneno)),
    PokemonOld(R.drawable.haunter, "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", listOf(R.drawable.fantasma, R.drawable.veneno)),
    PokemonOld(R.drawable.gengar, "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", listOf(R.drawable.fantasma, R.drawable.veneno)),
    PokemonOld(R.drawable.onix, "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", listOf(R.drawable.roca, R.drawable.tierra)),
    PokemonOld(R.drawable.drowzee, "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.hypno, "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.krabby, "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.kingler, "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.voltorb, "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.electrode, "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.exeggcute, "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", listOf(R.drawable.planta, R.drawable.psiquico)),
    PokemonOld(R.drawable.exeggutor, "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", listOf(R.drawable.planta, R.drawable.psiquico)),
    PokemonOld(R.drawable.cubone, "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.marowak, "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", listOf(R.drawable.tierra)),
    PokemonOld(R.drawable.hitmonlee, "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.hitmonchan, "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", listOf(R.drawable.lucha)),
    PokemonOld(R.drawable.lickitung, "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.koffing, "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.weezing, "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", listOf(R.drawable.veneno)),
    PokemonOld(R.drawable.rhyhorn, "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", listOf(R.drawable.tierra, R.drawable.roca)),
    PokemonOld(R.drawable.rhydon, "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", listOf(R.drawable.tierra, R.drawable.roca)),
    PokemonOld(R.drawable.chansey, "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.tangela, "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", listOf(R.drawable.planta)),
    PokemonOld(R.drawable.kangaskhan, "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.horsea, "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.seadra, "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.goldeen, "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.seaking, "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.staryu, "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.starmie, "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.", listOf(R.drawable.agua, R.drawable.psiquico)),
    PokemonOld(R.drawable.mrmime, "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", listOf(R.drawable.psiquico, R.drawable.hada)),
    PokemonOld(R.drawable.scyther, "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", listOf(R.drawable.bicho, R.drawable.volador)),
    PokemonOld(R.drawable.jynx, "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", listOf(R.drawable.hielo, R.drawable.psiquico)),
    PokemonOld(R.drawable.electabuzz, "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.magmar, "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.pinsir, "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", listOf(R.drawable.bicho)),
    PokemonOld(R.drawable.tauros, "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.magikarp, "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.gyarados, "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", listOf(R.drawable.agua, R.drawable.volador)),
    PokemonOld(R.drawable.lapras, "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", listOf(R.drawable.agua, R.drawable.hielo)),
    PokemonOld(R.drawable.ditto, "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.eevee, "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.vaporeon, "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.", listOf(R.drawable.agua)),
    PokemonOld(R.drawable.jolteon, "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", listOf(R.drawable.electrico)),
    PokemonOld(R.drawable.flareon, "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", listOf(R.drawable.fuego)),
    PokemonOld(R.drawable.porygon, "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.omanyte, "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", listOf(R.drawable.roca, R.drawable.agua)),
    PokemonOld(R.drawable.omastar, "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.", listOf(R.drawable.roca, R.drawable.agua)),
    PokemonOld(R.drawable.kabuto, "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", listOf(R.drawable.roca, R.drawable.agua)),
    PokemonOld(R.drawable.kabutops, "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", listOf(R.drawable.roca, R.drawable.agua)),
    PokemonOld(R.drawable.aerodactyl, "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", listOf(R.drawable.roca, R.drawable.volador)),
    PokemonOld(R.drawable.snorlax, "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", listOf(R.drawable.normal)),
    PokemonOld(R.drawable.articuno, "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", listOf(R.drawable.hielo, R.drawable.volador)),
    PokemonOld(R.drawable.zapdos, "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.", listOf(R.drawable.electrico, R.drawable.volador)),
    PokemonOld(R.drawable.moltres, "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", listOf(R.drawable.fuego, R.drawable.volador)),
    PokemonOld(R.drawable.dratini, "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", listOf(R.drawable.dragon)),
    PokemonOld(R.drawable.dragonair, "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", listOf(R.drawable.dragon)),
    PokemonOld(R.drawable.dragonite, "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", listOf(R.drawable.dragon, R.drawable.volador)),
    PokemonOld(R.drawable.mewtwo, "Mewtwo", "Fue creado por un científico tras años de horribles experimentos de manipulación genética.", listOf(R.drawable.psiquico)),
    PokemonOld(R.drawable.mew, "Mew", "Se dice que contiene la composición genética de todos los Pokémon. Es muy raramente visto.", listOf(R.drawable.psiquico))
)

fun debilidadesTipo(tipo:Int):List<Int>{
    var debilidadesTipo:MutableList<Int> = mutableListOf()
    when(tipo){
        R.drawable.planta -> {
            if(!debilidadesTipo.contains(R.drawable.fuego))debilidadesTipo.add(R.drawable.fuego)
            if(!debilidadesTipo.contains(R.drawable.hielo))debilidadesTipo.add(R.drawable.hielo)
            if(!debilidadesTipo.contains(R.drawable.veneno))debilidadesTipo.add(R.drawable.veneno)
            if(!debilidadesTipo.contains(R.drawable.bicho))debilidadesTipo.add(R.drawable.bicho)
            if(!debilidadesTipo.contains(R.drawable.volador))debilidadesTipo.add(R.drawable.volador)
        }
        R.drawable.agua -> {
            if(!debilidadesTipo.contains(R.drawable.planta))debilidadesTipo.add(R.drawable.planta)
            if(!debilidadesTipo.contains(R.drawable.electrico))debilidadesTipo.add(R.drawable.electrico)
        }
        R.drawable.fuego -> {
            if(!debilidadesTipo.contains(R.drawable.agua))debilidadesTipo.add(R.drawable.agua)
            if(!debilidadesTipo.contains(R.drawable.roca))debilidadesTipo.add(R.drawable.roca)
            if(!debilidadesTipo.contains(R.drawable.tierra))debilidadesTipo.add(R.drawable.tierra)
        }
        R.drawable.lucha -> {
            if(!debilidadesTipo.contains(R.drawable.volador))debilidadesTipo.add(R.drawable.volador)
            if(!debilidadesTipo.contains(R.drawable.hada))debilidadesTipo.add(R.drawable.hada)
            if(!debilidadesTipo.contains(R.drawable.psiquico))debilidadesTipo.add(R.drawable.psiquico)
        }
        R.drawable.veneno -> {
            if(!debilidadesTipo.contains(R.drawable.tierra))debilidadesTipo.add(R.drawable.tierra)
            if(!debilidadesTipo.contains(R.drawable.fuego))debilidadesTipo.add(R.drawable.psiquico)
        }
        R.drawable.acero -> {
            if(!debilidadesTipo.contains(R.drawable.lucha))debilidadesTipo.add(R.drawable.lucha)
            if(!debilidadesTipo.contains(R.drawable.fuego))debilidadesTipo.add(R.drawable.fuego)
            if(!debilidadesTipo.contains(R.drawable.tierra))debilidadesTipo.add(R.drawable.tierra)
        }
        R.drawable.bicho -> {
            if(!debilidadesTipo.contains(R.drawable.volador))debilidadesTipo.add(R.drawable.volador)
            if(!debilidadesTipo.contains(R.drawable.fuego))debilidadesTipo.add(R.drawable.fuego)
            if(!debilidadesTipo.contains(R.drawable.roca))debilidadesTipo.add(R.drawable.roca)
        }
        R.drawable.hada -> {
            if(!debilidadesTipo.contains(R.drawable.acero))debilidadesTipo.add(R.drawable.acero)
            if(!debilidadesTipo.contains(R.drawable.veneno))debilidadesTipo.add(R.drawable.veneno)
        }
        R.drawable.electrico -> {
            if(!debilidadesTipo.contains(R.drawable.tierra))debilidadesTipo.add(R.drawable.tierra)
        }
        R.drawable.dragon -> {
            if(!debilidadesTipo.contains(R.drawable.hada))debilidadesTipo.add(R.drawable.hada)
            if(!debilidadesTipo.contains(R.drawable.dragon))debilidadesTipo.add(R.drawable.dragon)
            if(!debilidadesTipo.contains(R.drawable.hielo))debilidadesTipo.add(R.drawable.hielo)
        }
        R.drawable.fantasma -> {
            if(!debilidadesTipo.contains(R.drawable.fantasma))debilidadesTipo.add(R.drawable.fantasma)
            if(!debilidadesTipo.contains(R.drawable.siniestro))debilidadesTipo.add(R.drawable.siniestro)
        }
        R.drawable.hielo -> {
            if(!debilidadesTipo.contains(R.drawable.fuego))debilidadesTipo.add(R.drawable.fuego)
            if(!debilidadesTipo.contains(R.drawable.lucha))debilidadesTipo.add(R.drawable.lucha)
            if(!debilidadesTipo.contains(R.drawable.acero))debilidadesTipo.add(R.drawable.acero)
            if(!debilidadesTipo.contains(R.drawable.roca))debilidadesTipo.add(R.drawable.roca)
        }
        R.drawable.psiquico -> {
            if(!debilidadesTipo.contains(R.drawable.siniestro))debilidadesTipo.add(R.drawable.siniestro)
            if(!debilidadesTipo.contains(R.drawable.bicho))debilidadesTipo.add(R.drawable.bicho)
            if(!debilidadesTipo.contains(R.drawable.fantasma))debilidadesTipo.add(R.drawable.fantasma)
        }
        R.drawable.roca -> {
            if(!debilidadesTipo.contains(R.drawable.acero))debilidadesTipo.add(R.drawable.acero)
            if(!debilidadesTipo.contains(R.drawable.agua))debilidadesTipo.add(R.drawable.agua)
            if(!debilidadesTipo.contains(R.drawable.planta))debilidadesTipo.add(R.drawable.planta)
            if(!debilidadesTipo.contains(R.drawable.lucha))debilidadesTipo.add(R.drawable.lucha)
            if(!debilidadesTipo.contains(R.drawable.tierra))debilidadesTipo.add(R.drawable.tierra)
        }
        R.drawable.tierra -> {
            if(!debilidadesTipo.contains(R.drawable.agua))debilidadesTipo.add(R.drawable.agua)
            if(!debilidadesTipo.contains(R.drawable.planta))debilidadesTipo.add(R.drawable.planta)
            if(!debilidadesTipo.contains(R.drawable.hielo))debilidadesTipo.add(R.drawable.hielo)
        }
        R.drawable.siniestro -> {
            if(!debilidadesTipo.contains(R.drawable.lucha))debilidadesTipo.add(R.drawable.lucha)
            if(!debilidadesTipo.contains(R.drawable.hada))debilidadesTipo.add(R.drawable.hada)
            if(!debilidadesTipo.contains(R.drawable.bicho))debilidadesTipo.add(R.drawable.bicho)
        }
        R.drawable.normal -> {
            if(!debilidadesTipo.contains(R.drawable.lucha))debilidadesTipo.add(R.drawable.lucha)
        }
        R.drawable.volador -> {
            if(!debilidadesTipo.contains(R.drawable.roca))debilidadesTipo.add(R.drawable.roca)
            if(!debilidadesTipo.contains(R.drawable.electrico))debilidadesTipo.add(R.drawable.electrico)
            if(!debilidadesTipo.contains(R.drawable.hielo))debilidadesTipo.add(R.drawable.hielo)
        }
    }
    return debilidadesTipo
}
fun fortalezasTipo(tipo:Int):List<Int>{
    var fortalezasTipo:MutableList<Int> = mutableListOf()
    when(tipo){
        R.drawable.planta -> {
            if(!fortalezasTipo.contains(R.drawable.agua))fortalezasTipo.add(R.drawable.agua)
            if(!fortalezasTipo.contains(R.drawable.roca))fortalezasTipo.add(R.drawable.roca)
            if(!fortalezasTipo.contains(R.drawable.tierra))fortalezasTipo.add(R.drawable.tierra)
        }
        R.drawable.agua -> {
            if(!fortalezasTipo.contains(R.drawable.fuego))fortalezasTipo.add(R.drawable.fuego)
            if(!fortalezasTipo.contains(R.drawable.roca))fortalezasTipo.add(R.drawable.roca)
            if(!fortalezasTipo.contains(R.drawable.tierra))fortalezasTipo.add(R.drawable.tierra)
        }
        R.drawable.fuego -> {
            if(!fortalezasTipo.contains(R.drawable.planta))fortalezasTipo.add(R.drawable.planta)
            if(!fortalezasTipo.contains(R.drawable.hielo))fortalezasTipo.add(R.drawable.hielo)
            if(!fortalezasTipo.contains(R.drawable.bicho))fortalezasTipo.add(R.drawable.bicho)
            if(!fortalezasTipo.contains(R.drawable.acero))fortalezasTipo.add(R.drawable.acero)
        }
        R.drawable.lucha -> {
            if(!fortalezasTipo.contains(R.drawable.normal))fortalezasTipo.add(R.drawable.normal)
            if(!fortalezasTipo.contains(R.drawable.siniestro))fortalezasTipo.add(R.drawable.siniestro)
            if(!fortalezasTipo.contains(R.drawable.hielo))fortalezasTipo.add(R.drawable.hielo)
            if(!fortalezasTipo.contains(R.drawable.roca))fortalezasTipo.add(R.drawable.roca)
            if(!fortalezasTipo.contains(R.drawable.acero))fortalezasTipo.add(R.drawable.acero)
        }
        R.drawable.veneno -> {
            if(!fortalezasTipo.contains(R.drawable.planta))fortalezasTipo.add(R.drawable.planta)
            if(!fortalezasTipo.contains(R.drawable.hada))fortalezasTipo.add(R.drawable.hada)
        }
        R.drawable.acero -> {
            if(!fortalezasTipo.contains(R.drawable.hada))fortalezasTipo.add(R.drawable.hada)
            if(!fortalezasTipo.contains(R.drawable.roca))fortalezasTipo.add(R.drawable.roca)
            if(!fortalezasTipo.contains(R.drawable.hielo))fortalezasTipo.add(R.drawable.hielo)
        }
        R.drawable.bicho -> {
            if(!fortalezasTipo.contains(R.drawable.planta))fortalezasTipo.add(R.drawable.planta)
            if(!fortalezasTipo.contains(R.drawable.psiquico))fortalezasTipo.add(R.drawable.psiquico)
            if(!fortalezasTipo.contains(R.drawable.siniestro))fortalezasTipo.add(R.drawable.siniestro)
        }
        R.drawable.hada -> {
            if(!fortalezasTipo.contains(R.drawable.lucha))fortalezasTipo.add(R.drawable.lucha)
            if(!fortalezasTipo.contains(R.drawable.siniestro))fortalezasTipo.add(R.drawable.siniestro)
            if(!fortalezasTipo.contains(R.drawable.dragon))fortalezasTipo.add(R.drawable.dragon)
        }
        R.drawable.electrico -> {
            if(!fortalezasTipo.contains(R.drawable.agua))fortalezasTipo.add(R.drawable.agua)
            if(!fortalezasTipo.contains(R.drawable.volador))fortalezasTipo.add(R.drawable.volador)
        }
        R.drawable.dragon -> {
            if(!fortalezasTipo.contains(R.drawable.dragon))fortalezasTipo.add(R.drawable.dragon)
        }
        R.drawable.fantasma -> {
            if(!fortalezasTipo.contains(R.drawable.fantasma))fortalezasTipo.add(R.drawable.fantasma)
            if(!fortalezasTipo.contains(R.drawable.psiquico))fortalezasTipo.add(R.drawable.psiquico)
        }
        R.drawable.hielo -> {
            if(!fortalezasTipo.contains(R.drawable.planta))fortalezasTipo.add(R.drawable.planta)
            if(!fortalezasTipo.contains(R.drawable.volador))fortalezasTipo.add(R.drawable.volador)
            if(!fortalezasTipo.contains(R.drawable.dragon))fortalezasTipo.add(R.drawable.dragon)
            if(!fortalezasTipo.contains(R.drawable.tierra))fortalezasTipo.add(R.drawable.tierra)
        }
        R.drawable.psiquico -> {
            if(!fortalezasTipo.contains(R.drawable.lucha))fortalezasTipo.add(R.drawable.lucha)
            if(!fortalezasTipo.contains(R.drawable.veneno))fortalezasTipo.add(R.drawable.veneno)
        }
        R.drawable.roca -> {
            if(!fortalezasTipo.contains(R.drawable.volador))fortalezasTipo.add(R.drawable.volador)
            if(!fortalezasTipo.contains(R.drawable.bicho))fortalezasTipo.add(R.drawable.bicho)
            if(!fortalezasTipo.contains(R.drawable.fuego))fortalezasTipo.add(R.drawable.fuego)
            if(!fortalezasTipo.contains(R.drawable.hielo))fortalezasTipo.add(R.drawable.hielo)
        }
        R.drawable.siniestro -> {
            if(!fortalezasTipo.contains(R.drawable.fantasma))fortalezasTipo.add(R.drawable.fantasma)
            if(!fortalezasTipo.contains(R.drawable.psiquico))fortalezasTipo.add(R.drawable.psiquico)
        }
        R.drawable.tierra -> {
            if(!fortalezasTipo.contains(R.drawable.veneno))fortalezasTipo.add(R.drawable.veneno)
            if(!fortalezasTipo.contains(R.drawable.fuego))fortalezasTipo.add(R.drawable.fuego)
            if(!fortalezasTipo.contains(R.drawable.roca))fortalezasTipo.add(R.drawable.roca)
            if(!fortalezasTipo.contains(R.drawable.acero))fortalezasTipo.add(R.drawable.acero)
            if(!fortalezasTipo.contains(R.drawable.electrico))fortalezasTipo.add(R.drawable.electrico)
        }
        R.drawable.volador->{
            if(!fortalezasTipo.contains(R.drawable.lucha))fortalezasTipo.add(R.drawable.lucha)
            if(!fortalezasTipo.contains(R.drawable.planta))fortalezasTipo.add(R.drawable.planta)

        }
        R.drawable.normal -> {}

    }
    return fortalezasTipo
}





fun debilidades(poke:PokemonOld):List<Int>{
    var debilidades: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1-> {
            var tipo1=poke.tipo[0]
            debilidades+=debilidadesTipo(tipo1)
        }
        2-> {
            var tipo1=poke.tipo[0]
            var tipo2=poke.tipo[1]
            debilidades+=debilidadesTipo(tipo1)
            debilidades+=debilidadesTipo(tipo2)
        }
    }
    return debilidades
}

fun fortalezas(poke:PokemonOld):List<Int>{
    var fortalezas: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1-> {
            var tipo1=poke.tipo[0]
            fortalezas+=fortalezasTipo(tipo1)
        }
        2-> {
            var tipo1=poke.tipo[0]
            var tipo2=poke.tipo[1]
            fortalezas+=fortalezasTipo(tipo1)
            fortalezas+=fortalezasTipo(tipo2)
        }
    }
    return fortalezas
}