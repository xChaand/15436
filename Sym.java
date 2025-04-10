import java.util.LinkedList;

public class Sym {
	private String type;

	public Sym(String type) {
		this.type = type;
	}

	public String toString() {
		return type;
	}
}

/**
 * Subclass to store types of parameters of a function
 */
class FuncSym extends Sym {
	private LinkedList<String> paramTypes;

	public FuncSym(String returnType) {
		super(returnType);
	}

	public void addFormals(LinkedList<String> list) {
		paramTypes = list;
	}

	public String toString() {
		String str = String.join(",", paramTypes);
		str += "->" + super.toString();
		return str;
	}
}

class StructSym extends Sym {
	public StructSym(String id) {
		super(id);
	}
}

/**
 * Subclass to analyze names in symtab of the struct
 */
class StructDefSym extends Sym {
	private SymTab symTab;

	public StructDefSym(SymTab table) {
		super("struct-def"); // debuging only (not actaul type)
		symTab = table;
	}

	public SymTab getSymTable() {
		return symTab;
	}
}