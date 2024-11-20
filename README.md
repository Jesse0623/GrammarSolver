# GrammarSolver
This program focuses on programming with recursion.
INSTRUCTIONS
Your deliverable will be to turn in a file named GrammarSolver.java to the course web site.
You will need support files GrammarMain.java, sentence.txt, and other input files from the course web site; place them in the same folder as your project.
LANGUAGES AND GRAMMERS
A formal language is a set of words and/or symbols along with a set of rules, collectively called the syntax of the language, defining how those symbols may be used together. A grammar is a way of describing the syntax and symbols of a formal language. Many language grammars can be described in a common format called Backus-Naur Form (BNF).
Some symbols in a grammar are called terminals because they represent fundamental words of the language. A terminal in the English language might be the word "boy" or "run" or "Jessica". Other symbols of the grammar are called nonterminals and represent high-level parts of the language syntax, such as a noun phrase or a sentence. Every non-terminal consists of one or more terminals; for example, the verb phrase "throw a ball" consists of three terminal words.
The BNF description of a language consists of a set of derivation rules, where each rule names a symbol and the legal transformations that can be performed between that symbol and other constructs in the language. For example, a BNF grammar for the English language might state that a sentence consists of a noun phrase and a verb phrase, and that a noun phrase can consist of an adjective followed by a noun or just a noun. Rules can be described recursively (in terms of themselves). For example, a noun phrase might consist of an adjective followed by another noun phrase.
Version 2.0
A BNF grammar is specified as an input file containing one or more rules, each on its own line, of the form:
non-terminal ::= rule | rule | rule | ... | rule
A ::= (colon colon equals) separator divides the non-terminal from its expansion rules. There will be exactly one ::= per line. A | (pipe) separates each rule; if there is only one rule for a given non-terminal, there will be no pipe characters.
