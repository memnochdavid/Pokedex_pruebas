package com.david.pokedex_pruebas.modelo

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.david.pokedex_pruebas.R
import com.david.pokedex_pruebas.modelo.PokeVistaAdapter.ViewHolder
import kotlin.text.toDouble
import kotlin.text.toDoubleOrNull

data class PokemonOld(
    var foto: Int=0,
    var name: String="",
    var desc: String="",
    var tipo: List<PokemonTipo> = listOf()
)

var listaPoke : List<PokemonOld> = listOf(
    PokemonOld(R.drawable.bulbasaur01, "Bulbasaur", "Puede sobrevivir largo tiempo sin probar bocado. Guarda energía en el bulbo de su espalda.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.ivisaur01, "Ivysaur", "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.venusaur01, "Venusaur", "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.charmander01, "Charmander", "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.charmeleon01, "Charmeleon", "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.charizard01, "Charizard", "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", listOf(PokemonTipo.FUEGO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.squirtle01, "Squirtle", "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.wartortle01, "Wartortle", "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.blastoise01, "Blastoise", "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.caterpie01, "Caterpie", "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", listOf(PokemonTipo.BICHO)),
    PokemonOld(R.drawable.metapod01, "Metapod", "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", listOf(PokemonTipo.BICHO)),
    PokemonOld(R.drawable.butterfree01, "Butterfree", "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.", listOf(PokemonTipo.BICHO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.weedle01, "Weedle", "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", listOf(PokemonTipo.BICHO, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.kakuna01, "Kakuna", "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", listOf(PokemonTipo.BICHO, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.beedril01, "Beedril", "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", listOf(PokemonTipo.BICHO, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.pidgey, "Pidgey", "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.pidgeotto, "Pidgeotto", "Su visión es extraordinaria. Aunque vuele muy alto, detectará todo movimiento de su presa.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.pidgeot, "Pidgeot", "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.rattata, "Rattata", "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.raticate, "Raticate", "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.spearow, "Spearow", "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.fearow, "Fearow", "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.ekans, "Ekans", "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.arbok, "Arbok", "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.pikachu, "Pikachu", "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.raichu, "Raichu", "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.sandshrew, "Sandshrew", "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.sandslash, "Sandslash", "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.nidoranf, "Nidoran♀", "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.nidorina, "Nidorina", "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.nidoqueen, "Nidoqueen", "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", listOf(PokemonTipo.VENENO, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.nidoranm, "Nidoran♂", "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.nidorino, "Nidorino", "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.nidoking, "Nidoking", "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", listOf(PokemonTipo.VENENO, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.clefairy, "Clefairy", "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", listOf(PokemonTipo.HADA)),
    PokemonOld(R.drawable.clefable, "Clefable", "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", listOf(PokemonTipo.HADA)),
    PokemonOld(R.drawable.vulpix, "Vulpix", "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.ninetales, "Ninetales", "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.jigglypuff, "Jigglypuff", "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", listOf(PokemonTipo.NORMAL, PokemonTipo.HADA)),
    PokemonOld(R.drawable.wigglytuff, "Wigglytuff", "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", listOf(PokemonTipo.NORMAL, PokemonTipo.HADA)),
    PokemonOld(R.drawable.zubat, "Zubat", "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", listOf(PokemonTipo.VENENO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.golbat, "Golbat", "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", listOf(PokemonTipo.VENENO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.oddish, "Oddish", "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.gloom, "Gloom", "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.vileplume, "Vileplume", "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.paras, "Paras", "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", listOf(PokemonTipo.BICHO, PokemonTipo.PLANTA)),
    PokemonOld(R.drawable.parasect, "Parasect", "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", listOf(PokemonTipo.BICHO, PokemonTipo.PLANTA)),
    PokemonOld(R.drawable.venonat, "Venonat", "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", listOf(PokemonTipo.BICHO, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.venomoth, "Venomoth", "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", listOf(PokemonTipo.BICHO, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.diglett, "Diglett", "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.dugtrio, "Dugtrio", "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.meowth, "Meowth", "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.persian, "Persian", "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.psyduck, "Psyduck", "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.golduck, "Golduck", "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.mankey, "Mankey", "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.primeape, "Primeape", "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.growlithe, "Growlithe", "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.arcanine, "Arcanine", "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.poliwag, "Poliwag", "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.poliwhirl, "Poliwhirl", "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.poliwrath, "Poliwrath", "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", listOf(PokemonTipo.AGUA, PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.abra, "Abra", "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.kadabra, "Kadabra", "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.alakazam, "Alakazam", "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.machop, "Machop", "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.machoke, "Machoke", "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.machamp, "Machamp", "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.bellsprout, "Bellsprout", "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.weepinbell, "Weepinbell", "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.victreebel, "Victreebel", "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", listOf(PokemonTipo.PLANTA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.tentacool, "Tentacool", "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", listOf(PokemonTipo.AGUA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.tentacruel, "Tentacruel", "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", listOf(PokemonTipo.AGUA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.geodude, "Geodude", "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", listOf(PokemonTipo.ROCA, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.graveler, "Graveler", "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", listOf(PokemonTipo.ROCA, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.golem, "Golem", "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", listOf(PokemonTipo.ROCA, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.ponyta, "Ponyta", "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.rapidash, "Rapidash", "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.slowpoke, "Slowpoke", "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", listOf(PokemonTipo.AGUA, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.slowbro, "Slowbro", "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", listOf(PokemonTipo.AGUA, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.magnemite, "Magnemite", "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", listOf(PokemonTipo.ELECTRICO, PokemonTipo.ACERO)),
    PokemonOld(R.drawable.magneton, "Magneton", "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", listOf(PokemonTipo.ELECTRICO, PokemonTipo.ACERO)),
    PokemonOld(R.drawable.farfetchd, "Farfetch'd", "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.doduo, "Doduo", "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.dodrio, "Dodrio", "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", listOf(PokemonTipo.NORMAL, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.seel, "Seel", "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.dewgong, "Dewgong", "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", listOf(PokemonTipo.AGUA, PokemonTipo.HIELO)),
    PokemonOld(R.drawable.grimer, "Grimer", "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.muk, "Muk", "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.shellder, "Shellder", "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.cloyster, "Cloyster", "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", listOf(PokemonTipo.AGUA, PokemonTipo.HIELO)),
    PokemonOld(R.drawable.gastly, "Gastly", "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", listOf(PokemonTipo.FANTASMA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.haunter, "Haunter", "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", listOf(PokemonTipo.FANTASMA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.gengar, "Gengar", "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", listOf(PokemonTipo.FANTASMA, PokemonTipo.VENENO)),
    PokemonOld(R.drawable.onix, "Onix", "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", listOf(PokemonTipo.ROCA, PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.drowzee, "Drowzee", "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.hypno, "Hypno", "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.krabby, "Krabby", "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.kingler, "Kingler", "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.voltorb, "Voltorb", "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.electrode, "Electrode", "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.exeggcute, "Exeggcute", "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", listOf(PokemonTipo.PLANTA, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.exeggutor, "Exeggutor", "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", listOf(PokemonTipo.PLANTA, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.cubone, "Cubone", "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.marowak, "Marowak", "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", listOf(PokemonTipo.TIERRA)),
    PokemonOld(R.drawable.hitmonlee, "Hitmonlee", "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.hitmonchan, "Hitmonchan", "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", listOf(PokemonTipo.LUCHA)),
    PokemonOld(R.drawable.lickitung, "Lickitung", "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.koffing, "Koffing", "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.weezing, "Weezing", "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", listOf(PokemonTipo.VENENO)),
    PokemonOld(R.drawable.rhyhorn, "Rhyhorn", "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", listOf(PokemonTipo.TIERRA, PokemonTipo.ROCA)),
    PokemonOld(R.drawable.rhydon, "Rhydon", "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", listOf(PokemonTipo.TIERRA, PokemonTipo.ROCA)),
    PokemonOld(R.drawable.chansey, "Chansey", "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.tangela, "Tangela", "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", listOf(PokemonTipo.PLANTA)),
    PokemonOld(R.drawable.kangaskhan, "Kangaskhan", "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.horsea, "Horsea", "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.seadra, "Seadra", "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.goldeen, "Goldeen", "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.seaking, "Seaking", "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.staryu, "Staryu", "Mientras su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.starmie, "Starmie", "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores.", listOf(PokemonTipo.AGUA, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.mrmime, "Mr. Mime", "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", listOf(PokemonTipo.PSIQUICO, PokemonTipo.HADA)),
    PokemonOld(R.drawable.scyther, "Scyther", "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", listOf(PokemonTipo.BICHO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.jynx, "Jynx", "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", listOf(PokemonTipo.HIELO, PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.electabuzz, "Electabuzz", "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.magmar, "Magmar", "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.pinsir, "Pinsir", "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", listOf(PokemonTipo.BICHO)),
    PokemonOld(R.drawable.tauros, "Tauros", "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.magikarp, "Magikarp", "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.gyarados, "Gyarados", "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", listOf(PokemonTipo.AGUA, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.lapras, "Lapras", "Este espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", listOf(PokemonTipo.AGUA, PokemonTipo.HIELO)),
    PokemonOld(R.drawable.ditto, "Ditto", "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.eevee, "Eevee", "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.vaporeon, "Vaporeon", "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua.", listOf(PokemonTipo.AGUA)),
    PokemonOld(R.drawable.jolteon, "Jolteon", "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", listOf(PokemonTipo.ELECTRICO)),
    PokemonOld(R.drawable.flareon, "Flareon", "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", listOf(PokemonTipo.FUEGO)),
    PokemonOld(R.drawable.porygon, "Porygon", "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.omanyte, "Omanyte", "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", listOf(PokemonTipo.ROCA, PokemonTipo.AGUA)),
    PokemonOld(R.drawable.omastar, "Omastar", "Picos afilados rodean su boca. Su concha es demasiado grande como para que se mueva libremente.", listOf(PokemonTipo.ROCA, PokemonTipo.AGUA)),
    PokemonOld(R.drawable.kabuto, "Kabuto", "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", listOf(PokemonTipo.ROCA, PokemonTipo.AGUA)),
    PokemonOld(R.drawable.kabutops, "Kabutops", "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", listOf(PokemonTipo.ROCA, PokemonTipo.AGUA)),
    PokemonOld(R.drawable.aerodactyl, "Aerodactyl", "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", listOf(PokemonTipo.ROCA, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.snorlax, "Snorlax", "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", listOf(PokemonTipo.NORMAL)),
    PokemonOld(R.drawable.articuno, "Articuno", "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", listOf(PokemonTipo.HIELO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.zapdos, "Zapdos", "Este legendario pájaro Pokémon solo aparece cuando el cielo se torna oscuro y caen rayos.", listOf(PokemonTipo.ELECTRICO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.moltres, "Moltres", "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", listOf(PokemonTipo.FUEGO, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.dratini, "Dratini", "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", listOf(PokemonTipo.DRAGON)),
    PokemonOld(R.drawable.dragonair, "Dragonair", "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", listOf(PokemonTipo.DRAGON)),
    PokemonOld(R.drawable.dragonite, "Dragonite", "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", listOf(PokemonTipo.DRAGON, PokemonTipo.VOLADOR)),
    PokemonOld(R.drawable.mewtwo, "Mewtwo", "Fue creado por un científico tras años de horribles experimentos de manipulación genética.", listOf(PokemonTipo.PSIQUICO)),
    PokemonOld(R.drawable.mew, "Mew", "Se dice que contiene la composición genética de todos los Pokémon. Es muy raramente visto.", listOf(PokemonTipo.PSIQUICO))
)

fun cambiaFondo(poke:PokemonOld,holder: ViewHolder){
    val header=holder.itemView.findViewById<View>(R.id.header)
    val center=holder.itemView.findViewById<View>(R.id.center)
    if(poke.tipo.size==1){
        when(poke.tipo[0]){
            PokemonTipo.PLANTA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.planta) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.AGUA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.agua) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.FUEGO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fuego) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.LUCHA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.lucha) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.VENENO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.veneno) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.ACERO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.acero) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.BICHO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.bicho) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.DRAGON -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.dragon) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.ELECTRICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.elec) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.HADA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hada) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.HIELO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hielo) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.PSIQUICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.siniestro) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.ROCA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.roca) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.TIERRA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.tierra) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.SINIESTRO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.psiq) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.NORMAL -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.normal) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.FANTASMA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fant) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.VOLADOR -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.vol) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
                center.setBackgroundColor(color)
            }
            PokemonTipo.NULL -> TODO()
        }
    }
    else if(poke.tipo.size==2){
        when(poke.tipo[0]){
            PokemonTipo.PLANTA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.planta) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.AGUA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.agua) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.FUEGO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fuego) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.LUCHA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.lucha) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.VENENO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.veneno) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.ACERO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.acero) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.BICHO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.bicho) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.DRAGON -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.dragon) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.ELECTRICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.elec) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.HADA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hada) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.HIELO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hielo) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.SINIESTRO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.siniestro) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.ROCA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.roca) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.TIERRA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.tierra) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.PSIQUICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.psiq) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.NORMAL -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.normal) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.FANTASMA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fant) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.VOLADOR -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.vol) // Assuming you have a color named 'green' in your colors.xml
                header.setBackgroundColor(color)
            }
            PokemonTipo.NULL -> TODO()
        }
        when(poke.tipo[1]){
            PokemonTipo.PLANTA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.planta) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.AGUA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.agua) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.FUEGO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fuego) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.LUCHA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.lucha) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.VENENO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.veneno) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.ACERO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.acero) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.BICHO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.bicho) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.DRAGON -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.dragon) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.ELECTRICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.elec) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.HADA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hada) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.HIELO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.hielo) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.SINIESTRO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.siniestro) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.ROCA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.roca) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.TIERRA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.tierra) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.PSIQUICO -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.psiq) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.NORMAL -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.normal) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.FANTASMA -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.fant) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.VOLADOR -> {
                val color = ContextCompat.getColor(holder.itemView.context, R.color.vol) // Assuming you have a color named 'green' in your colors.xml
                center.setBackgroundColor(color)
            }
            PokemonTipo.NULL -> TODO()
        }

    }




}//fondo del header para cada tipo de pokemon

enum class PokemonTipo {
    PLANTA, AGUA, FUEGO, LUCHA, VENENO, ACERO, BICHO, DRAGON, ELECTRICO,HADA, HIELO, PSIQUICO, ROCA, TIERRA, SINIESTRO, NORMAL, VOLADOR, FANTASMA, NULL
}

val efectividad = mapOf(
    Pair(PokemonTipo.PLANTA, PokemonTipo.AGUA) to "2",
    Pair(PokemonTipo.PLANTA, PokemonTipo.TIERRA) to "2",
    Pair(PokemonTipo.PLANTA, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.PLANTA, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.BICHO) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.DRAGON) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.PLANTA) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.VENENO) to "0.5",
    Pair(PokemonTipo.PLANTA, PokemonTipo.VOLADOR) to "0.5",
    Pair(PokemonTipo.AGUA, PokemonTipo.FUEGO) to "2",
    Pair(PokemonTipo.AGUA, PokemonTipo.TIERRA) to "2",
    Pair(PokemonTipo.AGUA, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.AGUA, PokemonTipo.AGUA) to "0.5",
    Pair(PokemonTipo.AGUA, PokemonTipo.DRAGON) to "0.5",
    Pair(PokemonTipo.AGUA, PokemonTipo.PLANTA) to "0.5",
    Pair(PokemonTipo.FUEGO, PokemonTipo.PLANTA) to "2",
    Pair(PokemonTipo.FUEGO, PokemonTipo.BICHO) to "2",
    Pair(PokemonTipo.FUEGO, PokemonTipo.HIELO) to "2",
    Pair(PokemonTipo.FUEGO, PokemonTipo.ACERO) to "2",
    Pair(PokemonTipo.FUEGO, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.FUEGO, PokemonTipo.DRAGON) to "0.5",
    Pair(PokemonTipo.FUEGO, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.FUEGO, PokemonTipo.ROCA) to "0.5",
    Pair(PokemonTipo.FUEGO, PokemonTipo.TIERRA) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.NORMAL) to "2",
    Pair(PokemonTipo.LUCHA, PokemonTipo.SINIESTRO) to "2",
    Pair(PokemonTipo.LUCHA, PokemonTipo.ACERO) to "2",
    Pair(PokemonTipo.LUCHA, PokemonTipo.HIELO) to "2",
    Pair(PokemonTipo.LUCHA, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.LUCHA, PokemonTipo.BICHO) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.HADA) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.PSIQUICO) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.VENENO) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.VOLADOR) to "0.5",
    Pair(PokemonTipo.LUCHA, PokemonTipo.FANTASMA) to "0",
    Pair(PokemonTipo.VENENO, PokemonTipo.HADA) to "2",
    Pair(PokemonTipo.VENENO, PokemonTipo.PLANTA) to "2",
    Pair(PokemonTipo.VENENO, PokemonTipo.FANTASMA) to "0.5",
    Pair(PokemonTipo.VENENO, PokemonTipo.ROCA) to "0.5",
    Pair(PokemonTipo.VENENO, PokemonTipo.TIERRA) to "0.5",
    Pair(PokemonTipo.VENENO, PokemonTipo.VENENO) to "0.5",
    Pair(PokemonTipo.VENENO, PokemonTipo.ACERO) to "0",
    Pair(PokemonTipo.ACERO, PokemonTipo.HADA) to "2",
    Pair(PokemonTipo.ACERO, PokemonTipo.HIELO) to "2",
    Pair(PokemonTipo.ACERO, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.ACERO, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.ACERO, PokemonTipo.AGUA) to "0.5",
    Pair(PokemonTipo.ACERO, PokemonTipo.ELECTRICO) to "0.5",
    Pair(PokemonTipo.ACERO, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.PLANTA) to "2",
    Pair(PokemonTipo.BICHO, PokemonTipo.PSIQUICO) to "2",
    Pair(PokemonTipo.BICHO, PokemonTipo.SINIESTRO) to "2",
    Pair(PokemonTipo.BICHO, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.FANTASMA) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.HADA) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.LUCHA) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.VENENO) to "0.5",
    Pair(PokemonTipo.BICHO, PokemonTipo.VOLADOR) to "0.5",
    Pair(PokemonTipo.DRAGON, PokemonTipo.DRAGON) to "2",
    Pair(PokemonTipo.DRAGON, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.DRAGON, PokemonTipo.HADA) to "0",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.AGUA) to "2",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.VOLADOR) to "2",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.DRAGON) to "0.5",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.ELECTRICO) to "0.5",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.PLANTA) to "0.5",
    Pair(PokemonTipo.ELECTRICO, PokemonTipo.TIERRA) to "0",
    Pair(PokemonTipo.HADA, PokemonTipo.DRAGON) to "2",
    Pair(PokemonTipo.HADA, PokemonTipo.LUCHA) to "2",
    Pair(PokemonTipo.HADA, PokemonTipo.SINIESTRO) to "2",
    Pair(PokemonTipo.HADA, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.HADA, PokemonTipo.VENENO) to "0.5",
    Pair(PokemonTipo.HIELO, PokemonTipo.PLANTA) to "2",
    Pair(PokemonTipo.HIELO, PokemonTipo.TIERRA) to "2",
    Pair(PokemonTipo.HIELO, PokemonTipo.VOLADOR) to "2",
    Pair(PokemonTipo.HIELO, PokemonTipo.DRAGON) to "2",
    Pair(PokemonTipo.HIELO, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.HIELO, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.HIELO, PokemonTipo.AGUA) to "0.5",
    Pair(PokemonTipo.HIELO, PokemonTipo.FUEGO) to "0.5",
    Pair(PokemonTipo.HIELO, PokemonTipo.HIELO) to "0.5",
    Pair(PokemonTipo.PSIQUICO, PokemonTipo.LUCHA) to "2",
    Pair(PokemonTipo.PSIQUICO, PokemonTipo.VENENO) to "2",
    Pair(PokemonTipo.PSIQUICO, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.PSIQUICO, PokemonTipo.PSIQUICO) to "0.5",
    Pair(PokemonTipo.PSIQUICO, PokemonTipo.SINIESTRO) to "0",
    Pair(PokemonTipo.ROCA, PokemonTipo.BICHO) to "2",
    Pair(PokemonTipo.ROCA, PokemonTipo.FUEGO) to "2",
    Pair(PokemonTipo.ROCA, PokemonTipo.HIELO) to "2",
    Pair(PokemonTipo.ROCA, PokemonTipo.VOLADOR) to "2",
    Pair(PokemonTipo.ROCA, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.ROCA, PokemonTipo.LUCHA) to "0.5",
    Pair(PokemonTipo.ROCA, PokemonTipo.TIERRA) to "0.5",
    Pair(PokemonTipo.TIERRA, PokemonTipo.ACERO) to "2",
    Pair(PokemonTipo.TIERRA, PokemonTipo.ELECTRICO) to "2",
    Pair(PokemonTipo.TIERRA, PokemonTipo.FUEGO) to "2",
    Pair(PokemonTipo.TIERRA, PokemonTipo.ROCA) to "2",
    Pair(PokemonTipo.TIERRA, PokemonTipo.VENENO) to "2",
    Pair(PokemonTipo.TIERRA, PokemonTipo.BICHO) to "0.5",
    Pair(PokemonTipo.TIERRA, PokemonTipo.PLANTA) to "0.5",
    Pair(PokemonTipo.TIERRA, PokemonTipo.VOLADOR) to "0",
    Pair(PokemonTipo.SINIESTRO, PokemonTipo.PSIQUICO) to "2",
    Pair(PokemonTipo.SINIESTRO, PokemonTipo.FANTASMA) to "2",
    Pair(PokemonTipo.SINIESTRO, PokemonTipo.LUCHA) to "0.5",
    Pair(PokemonTipo.SINIESTRO, PokemonTipo.HADA) to "0.5",
    Pair(PokemonTipo.SINIESTRO, PokemonTipo.SINIESTRO) to "0.5",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.PLANTA) to "2",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.BICHO) to "2",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.LUCHA) to "2",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.ELECTRICO) to "0.5",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.ROCA) to "0.5",
    Pair(PokemonTipo.VOLADOR, PokemonTipo.HIELO) to "0.5",////
    Pair(PokemonTipo.FANTASMA, PokemonTipo.FANTASMA) to "2",
    Pair(PokemonTipo.FANTASMA, PokemonTipo.PSIQUICO) to "2",
    Pair(PokemonTipo.FANTASMA, PokemonTipo.SINIESTRO) to "0.5",
    Pair(PokemonTipo.FANTASMA, PokemonTipo.NORMAL) to "0",
    Pair(PokemonTipo.NORMAL, PokemonTipo.ACERO) to "0.5",
    Pair(PokemonTipo.NORMAL, PokemonTipo.ROCA) to "0.5",
    Pair(PokemonTipo.NORMAL, PokemonTipo.FANTASMA) to "0"
)

fun debs(poke: PokemonOld): List<Int> {
    val debilidades = mutableListOf<Int>()

    when (poke.tipo.size) {
        1 -> {
            for ((key, value) in efectividad) {
                if (key.second == poke.tipo[0] && value == "2") {
                    debilidades.add(enumToDrawable(key.first))
                }
            }
        }
        2 -> {
            // 1. Accumulate weaknesses from both types
            for ((key, value) in efectividad) {
                if (key.second == poke.tipo[0] && value == "2") {
                    debilidades.add(enumToDrawable(key.first))
                }
                if (key.second == poke.tipo[1] && value == "2") {
                    //if (!debilidades.contains(enumToDrawable(key.first))) {
                        debilidades.add(enumToDrawable(key.first))
                    //}
                }
            }

            for ((key, value) in efectividad) {
                if ((key.first == poke.tipo[0] || key.first == poke.tipo[1]) && (value == "0.5" || value == "0")) {
                    if (efectividad[Pair(key.second, poke.tipo[0])] == "0.5" ||
                        efectividad[Pair(key.second, poke.tipo[0])] == "0" ||
                        efectividad[Pair(key.second, poke.tipo[1])] == "0.5" ||
                        efectividad[Pair(key.second, poke.tipo[1])] == "0") {
                        debilidades.remove(enumToDrawable(key.second))
                    }
                }
            }
        }
    }
    return debilidades.distinct()
}
fun forts(poke:PokemonOld):List<Int>{
    val fortalezas: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1->{
            for(i in efectividad){
                if(i.key.first==poke.tipo[0] && i.value.equals("2")) {
                    fortalezas.add(enumToDrawable(i.key.second))
                }
            }
        }
        2->{
            for(i in efectividad){
                if(i.key.first==poke.tipo[0] && i.value.equals("2")) {
                    fortalezas.add(enumToDrawable(i.key.second))
                }
            }
            for(i in efectividad){
                if(i.key.first==poke.tipo[1] && i.value.equals("2")) {
                    //if(!fortalezas.contains(enumToDrawable(i.key.second)))fortalezas.add(enumToDrawable(i.key.second))
                    fortalezas.add(enumToDrawable(i.key.second))
                }
            }
        }
    }

    return fortalezas.distinct()
}
fun inmune(poke:PokemonOld):List<Int>{
    val inmu: MutableList<Int> = mutableListOf()
    when(poke.tipo.size){
        1-> {
            for (i in efectividad) {
                if (i.key.second == poke.tipo[0] && i.value.equals("0")) {
                    inmu.add(enumToDrawable(i.key.first))
                }
            }
        }
        2-> {
            for (i in efectividad) {
                if (i.key.second == poke.tipo[0] && i.value.equals("0")) {
                    inmu.add(enumToDrawable(i.key.first))
                }
            }
            for (i in efectividad) {
                if (i.key.second == poke.tipo[1] && i.value.equals("0")) {
                    inmu.add(enumToDrawable(i.key.first))
                }
            }
        }
    }
    return inmu.distinct()
}






fun enumToDrawable(tipo:PokemonTipo):Int{
    return when(tipo){
        PokemonTipo.PLANTA -> R.drawable.planta
        PokemonTipo.AGUA -> R.drawable.agua
        PokemonTipo.FUEGO -> R.drawable.fuego
        PokemonTipo.LUCHA -> R.drawable.lucha
        PokemonTipo.VENENO -> R.drawable.veneno
        PokemonTipo.ACERO -> R.drawable.acero
        PokemonTipo.BICHO -> R.drawable.bicho
        PokemonTipo.DRAGON -> R.drawable.dragon
        PokemonTipo.ELECTRICO -> R.drawable.electrico
        PokemonTipo.HADA -> R.drawable.hada
        PokemonTipo.HIELO -> R.drawable.hielo
        PokemonTipo.PSIQUICO -> R.drawable.psiquico
        PokemonTipo.ROCA -> R.drawable.roca
        PokemonTipo.TIERRA -> R.drawable.tierra
        PokemonTipo.SINIESTRO -> R.drawable.siniestro
        PokemonTipo.NORMAL -> R.drawable.normal
        PokemonTipo.VOLADOR -> R.drawable.volador
        PokemonTipo.FANTASMA -> R.drawable.fantasma
        else -> { com.android.car.ui.R.drawable.car_ui_icon_error}
    }
}
fun drawableToEnum(drawable:Int):PokemonTipo{
    return when(drawable){
        R.drawable.planta -> PokemonTipo.PLANTA
        R.drawable.agua -> PokemonTipo.AGUA
        R.drawable.fuego -> PokemonTipo.FUEGO
        R.drawable.lucha -> PokemonTipo.LUCHA
        R.drawable.veneno -> PokemonTipo.VENENO
        R.drawable.acero -> PokemonTipo.ACERO
        R.drawable.bicho -> PokemonTipo.BICHO
        R.drawable.dragon -> PokemonTipo.DRAGON
        R.drawable.electrico -> PokemonTipo.ELECTRICO
        R.drawable.hada -> PokemonTipo.HADA
        R.drawable.hielo -> PokemonTipo.HIELO
        R.drawable.psiquico -> PokemonTipo.PSIQUICO
        R.drawable.roca -> PokemonTipo.ROCA
        R.drawable.tierra -> PokemonTipo.TIERRA
        R.drawable.siniestro -> PokemonTipo.SINIESTRO
        R.drawable.normal -> PokemonTipo.NORMAL
        R.drawable.volador -> PokemonTipo.VOLADOR
        R.drawable.fantasma -> PokemonTipo.FANTASMA
        else -> { PokemonTipo.NULL}
    }
}

