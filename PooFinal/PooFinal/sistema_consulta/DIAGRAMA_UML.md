```
DIAGRAMA DE CLASSES UML - SISTEMA DE CONSULTA MÉDICA

┌─────────────────────────────────┐
│      <<interface>>              │
│       Participante              │
├─────────────────────────────────┤
│ + participar()                  │
└─────────────────────────────────┘
          △                        
          │ implements             
          │                        
          │                        
┌─────────────────────────────────┐          ┌──────────────────────────────┐
│       <<abstract>>              │          │   <<interface>>              │
│         Pessoa                  │          │      Utilizavel              │
├─────────────────────────────────┤          ├──────────────────────────────┤
│ - id: Long                      │          │ + utilizar()                 │
│ - nome: String                  │          └──────────────────────────────┘
│ - email: String                 │                    △
├─────────────────────────────────┤                    │ implements
│ + getId(): Long                 │                    │
│ + getNome(): String             │                    │
│ + getEmail(): String            │                    │
│ + exibirInfo(): void            │                    │
│ + setNome(String)               │                    │
│ + setEmail(String)              │                    │
└─────────────────────────────────┘                    │
     △              △                                  │
     │              │                                  │
  Herança        Herança                           Herança
     │              │                                  │
     │              │                                  │
┌────────────────┐  ┌──────────────────┐              │
│   Paciente     │  │   Funcionario    │              │
├────────────────┤  ├──────────────────┤              │
│ - cpf: String  │  │ - crm: String    │              │
│ - telefone:    │  │ - especialidade: │              │
│   String       │  │   String         │              │
├────────────────┤  ├──────────────────┤              │
│ + getCpf()     │  │ + getCrm()       │              │
│ + getTelefone()│  │ + getEspecialid()│              │
│ + exibirInfo() │  │ + exibirInfo()   │              │
└────────────────┘  └──────────────────┘              │
                                                      │
                                                      │
┌──────────────────────────────────────────────────────┘
│                                                      
│ (herança)                                           
│                                                      
└─────────────────────────────┐                        
                              │                        
              ┌───────────────┴────────────┐           
              │                            │           
┌─────────────────────────────┐  ┌────────────────────────┐
│      <<abstract>>           │  │      Consulta          │
│       Recurso               │  ├────────────────────────┤
├─────────────────────────────┤  │ - descricaoConsulta:   │
│ - id: Integer               │  │   String               │
│ - nome: String              │  │ - valor: Double        │
│ - anoFabricacao: Integer    │  ├────────────────────────┤
├─────────────────────────────┤  │ + getDescricao()       │
│ + getId(): Integer          │  │ + getValor()           │
│ + getNome(): String         │  │ + descricao(): void    │
│ + getAnoFabricacao()        │  └────────────────────────┘
│ + descricao(): void         │
└─────────────────────────────┘

                    ┌──────────────────────────────┐
                    │     Atendimento              │
                    ├──────────────────────────────┤
                    │ - id: Integer                │
                    │ - paciente: Pessoa           │
                    │ - medico: Pessoa             │
                    │ - consulta: Recurso          │
                    │ - dataAtendimento: String    │
                    │ - diagnostico: String        │
                    │ - observacoes: String        │
                    ├──────────────────────────────┤
                    │ + getId(): Integer           │
                    │ + getPaciente(): Pessoa      │
                    │ + getMedico(): Pessoa        │
                    │ + getConsulta(): Recurso     │
                    │ + exibirDetalhes(): void     │
                    └──────────────────────────────┘
                          △        △         △
                          │        │         │
                    Associação    1    0..* (1-N)
                    
┌──────────────────┐  ┌──────────────────┐  ┌─────────────────┐
│   PessoaDAO      │  │   RecursoDAO     │  │ AtendimentoDAO  │
├──────────────────┤  ├──────────────────┤  ├─────────────────┤
│ - pessoas:List   │  │ - recursos:List  │  │ -atendimentos:  │
├──────────────────┤  ├──────────────────┤  │  List           │
│ + salvarPessoa() │  │ + salvarRecurso()│  ├─────────────────┤
│ + getTodasPessoas│  │ + getRecursos()  │  │ + salvarAtendi..│
│ + getPessoaById()│  │ + getRecursoById()  │ + getAtendimentos()
│ + atualizar..()  │  │ + atualizar..()  │  │ + getAtendimentoById()
│ + deletarPessoa()│  │ + deletarRecurso()  │ + atualizar..()
└──────────────────┘  └──────────────────┘  │ + deletarAtendi.()
                                             └─────────────────┘

RELACIONAMENTOS:
- Participante ◁|------ Pessoa (implementação)
- Utilizavel  ◁|------ Recurso (implementação)
- Pessoa ◁|------ Paciente (herança)
- Pessoa ◁|------ Funcionario (herança)
- Recurso ◁|------ Consulta (herança)
- Atendimento ----* Pessoa (2..2: paciente e medico)
- Atendimento ----1 Recurso (consulta)
```
