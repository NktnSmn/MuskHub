package nktn.smn.muskhub.navigation

interface Route
interface SimpleRoute
interface NewScreenRoute : SimpleRoute

class Add(val screen: Screen) : NewScreenRoute
class Replace(val screen: Screen) : NewScreenRoute
class Back : SimpleRoute

interface CompositeRoute

class ChangeRoot(val screen: Screen): NewScreenRoute
class AddChain(val screens: List<Screen>): NewScreenRoute
class Hierarchical(val route: NewScreenRoute, val childRoute: Route?)