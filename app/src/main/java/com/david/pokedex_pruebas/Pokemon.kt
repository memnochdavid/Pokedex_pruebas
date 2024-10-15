package com.david.pokedex_pruebas

import java.util.Locale

data class Pokemon(
    var foto: Int=0,
    var name: String="",
    var desc: String=""
)

var listaPoke : List<Pokemon> = listOf(
    Pokemon((R.drawable.bulbasaur01), "Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.")
    ,Pokemon((R.drawable.ivisaur01), "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.")
    ,Pokemon((R.drawable.venusaur01), "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.")
    ,Pokemon((R.drawable.charmander01), "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.")
    ,Pokemon((R.drawable.charmeleon01), "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.")
    ,Pokemon((R.drawable.charizard01), "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.")
    ,Pokemon((R.drawable.squirtle01), "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.")
    ,Pokemon((R.drawable.wartortle01), "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.")
    ,Pokemon((R.drawable.blastoise01), "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.")
    ,Pokemon((R.drawable.caterpie01), "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.")
    ,Pokemon((R.drawable.metapod01), "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.")
    ,Pokemon((R.drawable.butterfree01), "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.")
    ,Pokemon((R.drawable.weedle01), "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.")
    ,Pokemon((R.drawable.kakuna01), "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.")
    ,Pokemon((R.drawable.beedril01), "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.")
    ,Pokemon((R.drawable.pidgey), "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.")
    ,Pokemon((R.drawable.pidgeotto), "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.")
    ,Pokemon((R.drawable.pidgeot), "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.")
    ,Pokemon((R.drawable.rattata), "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.")
    ,Pokemon((R.drawable.raticate), "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.")
    ,Pokemon((R.drawable.spearow), "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.")
    ,Pokemon((R.drawable.fearow), "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.")
    ,Pokemon((R.drawable.ekans), "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.")
    ,Pokemon((R.drawable.arbok), "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.")
    ,Pokemon((R.drawable.pikachu), "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.")
    ,Pokemon((R.drawable.raichu), "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.")
    ,Pokemon((R.drawable.sandshrew), "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.")
    ,Pokemon((R.drawable.sandslash), "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.")
    ,Pokemon((R.drawable.nidoranf), "Nidoran F", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.")
    ,Pokemon((R.drawable.nidorina), "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.")
    ,Pokemon((R.drawable.nidoqueen), "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.")
    ,Pokemon((R.drawable.nidoranm), "Nidoran M", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.")
    ,Pokemon((R.drawable.nidorino), "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.")
    ,Pokemon((R.drawable.nidoking), "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.")
    ,Pokemon((R.drawable.clefairy), "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.")
    ,Pokemon((R.drawable.clefable), "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.")
    ,Pokemon((R.drawable.vulpix), "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.")
    ,Pokemon((R.drawable.ninetales), "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.")
    ,Pokemon((R.drawable.jigglypuff), "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.")
    ,Pokemon((R.drawable.wigglytuff), "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.")
    ,Pokemon((R.drawable.zubat), "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.")
    ,Pokemon((R.drawable.golbat), "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.")
    ,Pokemon((R.drawable.oddish), "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.")
    ,Pokemon((R.drawable.gloom), "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.")
    ,Pokemon((R.drawable.vileplume), "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.")
    ,Pokemon((R.drawable.paras), "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.")
    ,Pokemon((R.drawable.parasect), "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.")
    ,Pokemon((R.drawable.venonat), "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.")
    ,Pokemon((R.drawable.venomoth), "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.")
    ,Pokemon((R.drawable.diglett), "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.")
    ,Pokemon((R.drawable.dugtrio), "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.")
    ,Pokemon((R.drawable.meowth), "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.")
    ,Pokemon((R.drawable.persian), "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.")
    ,Pokemon((R.drawable.psyduck), "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.")
    ,Pokemon((R.drawable.golduck), "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.")
    ,Pokemon((R.drawable.mankey), "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.")
    ,Pokemon((R.drawable.primeape), "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.")
    ,Pokemon((R.drawable.growlithe), "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.")
    ,Pokemon((R.drawable.arcanine), "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.")
    ,Pokemon((R.drawable.poliwag), "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.")
    ,Pokemon((R.drawable.poliwhirl), "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.")
    ,Pokemon((R.drawable.poliwrath), "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.")
    ,Pokemon((R.drawable.abra), "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.")
    ,Pokemon((R.drawable.kadabra), "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.")
    ,Pokemon((R.drawable.alakazam), "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.")
    ,Pokemon((R.drawable.machop), "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.")
    ,Pokemon((R.drawable.machoke), "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.")
    ,Pokemon((R.drawable.machamp), "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.")
    ,Pokemon((R.drawable.bellsprout), "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.")
    ,Pokemon((R.drawable.weepinbell), "Weeperbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.")
    ,Pokemon((R.drawable.victreebel), "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.")
    ,Pokemon((R.drawable.tentacool), "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.")
    ,Pokemon((R.drawable.tentacruel), "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.")
    ,Pokemon((R.drawable.geodude), "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.")
    ,Pokemon((R.drawable.graveler), "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!")
    ,Pokemon((R.drawable.golem), "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.")
    ,Pokemon((R.drawable.ponyta), "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.")
    ,Pokemon((R.drawable.rapidash), "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.")
    ,Pokemon((R.drawable.slowpoke), "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.")
    ,Pokemon((R.drawable.slowbro), "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.")
    ,Pokemon((R.drawable.magnemite), "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.")
    ,Pokemon((R.drawable.magneton), "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.")
    ,Pokemon((R.drawable.farfetchd), "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.")
    ,Pokemon((R.drawable.doduo), "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.")
    ,Pokemon((R.drawable.dodrio), "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.")
    ,Pokemon((R.drawable.seel), "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.")
    ,Pokemon((R.drawable.dewgong), "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.")
    ,Pokemon((R.drawable.grimer), "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!")
    ,Pokemon((R.drawable.muk), "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.")
    ,Pokemon((R.drawable.shellder), "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.")
    ,Pokemon((R.drawable.cloyster), "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.")
    ,Pokemon((R.drawable.gastly), "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.")
    ,Pokemon((R.drawable.haunter), "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.")
    ,Pokemon((R.drawable.gengar), "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.")
    ,Pokemon((R.drawable.onix), "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.")
    ,Pokemon((R.drawable.drowzee), "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.")
    ,Pokemon((R.drawable.hypno), "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.")
    ,Pokemon((R.drawable.krabby), "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.")
    ,Pokemon((R.drawable.kingler), "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.")
    ,Pokemon((R.drawable.voltorb), "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.")
    ,Pokemon((R.drawable.electrode), "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.")
    ,Pokemon((R.drawable.exeggcute), "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.")
    ,Pokemon((R.drawable.exeggutor), "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.")
    ,Pokemon((R.drawable.cubone), "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.")
    ,Pokemon((R.drawable.marowak), "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.")
    ,Pokemon((R.drawable.hitmonlee), "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.")
    ,Pokemon((R.drawable.hitmonchan), "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.")
    ,Pokemon((R.drawable.lickitung), "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.")
    ,Pokemon((R.drawable.koffing), "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.")
    ,Pokemon((R.drawable.weezing), "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.")
    ,Pokemon((R.drawable.rhyhorn), "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.")
    ,Pokemon((R.drawable.rhydon), "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.")
    ,Pokemon((R.drawable.chansey), "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.")
    ,Pokemon((R.drawable.tangela), "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.")
    ,Pokemon((R.drawable.kangaskhan), "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.")
    ,Pokemon((R.drawable.horsea), "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.")
    ,Pokemon((R.drawable.seadra), "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.")
    ,Pokemon((R.drawable.goldeen), "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.")
    ,Pokemon((R.drawable.seaking), "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.")
    ,Pokemon((R.drawable.staryu), "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.")
    ,Pokemon((R.drawable.starmie), "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.")
    ,Pokemon((R.drawable.mrmime), "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.")
    ,Pokemon((R.drawable.scyther), "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.")
    ,Pokemon((R.drawable.jynx), "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.")
    ,Pokemon((R.drawable.electabuzz), "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.")
    ,Pokemon((R.drawable.magmar), "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.")
    ,Pokemon((R.drawable.pinsir), "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.")
    ,Pokemon((R.drawable.tauros), "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.")
    ,Pokemon((R.drawable.magikarp), "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.")
    ,Pokemon((R.drawable.gyarados), "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.")
    ,Pokemon((R.drawable.lapras), "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.")
    ,Pokemon((R.drawable.ditto), "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.")
    ,Pokemon((R.drawable.eevee), "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.")
    ,Pokemon((R.drawable.vaporeon), "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.")
    ,Pokemon((R.drawable.jolteon), "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.")
    ,Pokemon((R.drawable.flareon), "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.")
    ,Pokemon((R.drawable.porygon), "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.")
    ,Pokemon((R.drawable.omanyte), "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.")
    ,Pokemon((R.drawable.omastar), "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.")
    ,Pokemon((R.drawable.kabuto), "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.")
    ,Pokemon((R.drawable.kabutops), "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.")
    ,Pokemon((R.drawable.aerodactyl), "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.")
    ,Pokemon((R.drawable.snorlax), "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.")
    ,Pokemon((R.drawable.articuno), "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.")
    ,Pokemon((R.drawable.zapdos), "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.")
    ,Pokemon((R.drawable.moltres), "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.")
    ,Pokemon((R.drawable.dratini), "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.")
    ,Pokemon((R.drawable.dragonair), "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.")
    ,Pokemon((R.drawable.dragonite), "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.")
    ,Pokemon((R.drawable.mewtwo), "Mewtwo", "Su ADN es casi el mismo que el de Mew. De todos modos, su tamaño y disposición son diferentes.")
    ,Pokemon((R.drawable.mew), "Mew", "Cuando es mirado a través de un microscopio, puede observarse el delicado pelo de este Pokémon.")
    ,Pokemon((R.drawable.missingno), "MISSINGNO", "Oops, parece que la has liado. Escribe bien el nombre.")
)


fun busca(poke: String): Int {
    for ((index, pokemon) in listaPoke.withIndex()) {
        if (pokemon.name.lowercase(Locale.ROOT).contains(poke.lowercase(Locale.ROOT))) {
            return index
        }
    };return -1
}