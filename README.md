# Valder's snippet extractor

Extract methods between multiples branches of the same project to identify diferences
in refactory tools

## Getting Started

All the configuration is done changing the parameters on the enum folder, each file changes a type of configuration;

	BranchesEnum : you should list the path of your branches here, if you want more just copy and paste, changing the path and the name of the enum variable
	
	GenerationConfigEnum : Change multiple parameters of generation including the extension of the generated file, name, folder where the snippets are going, the path of the project, etc.
	
	FileTypeConfig: Changes the extension of the read file
	
	MasterEnum: setup the path of the master branch
	
	RegexEnum: changes the pattern based extraction of the methods
	
### Prerequisites

	Java 1.8 and Maven

### Installing

	Compile via maven, and run the main file.

## Authors		
	Vito	

## Acknowledgments
	Thanks Vito