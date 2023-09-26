package module

object ModuleManager {
    var moduleMap: HashMap<String, Module> = hashMapOf(

    )

    fun getModule(name: String): Module = moduleMap[name] ?: error("Failed to retrieve module $name")
}