package pt.isel.mpd.part3;

import java.io.*;
import java.lang.reflect.Member;
import java.util.function.Predicate;


public class PlantUmlBuilder {
    
    /**
     * Constrói uma instância que vai emitir os tipos via o writer
     * recebido na construção
     * @param writer
     */
    public PlantUmlBuilder(Writer writer) {
        // TODO
    }
    
    /**
     * @param fileName
     */
    public PlantUmlBuilder(String fileName)  {
        // TODO
    }
   
    /**
     * Adiciona, ao conjunto de tipos a processar, os tipos (classes ou interfaces), dos representantes
     * presentes no array "types", bem como as interfaces direta ou indiretamente implementadas e,
     * caso sejam classes, as suas superclasses.
     * @param types
     */
    public PlantUmlBuilder addTypes(Class<?> ... types) {
        // TODO
        return null;
    }
    
    /**
     * Define um filtro (predicado) para seleccionar os membros a emitir
     * no ficheiro PlantUml
     * @param filter
     */
    public PlantUmlBuilder memberFilter(Predicate<Member> filter ) {
        // TODO
        return null;
    }
    
    /**
     * Define um filtro (predicado) para seleccionar os tipos a emitir
     * no ficheiro PlantUml
     * @param filter
     */
    public PlantUmlBuilder typeFilter(Predicate<Class<?>> filter ) {
        // TODO
        return null;
    }

    /**
     * Emite os tipos seleccionados e os correspondentes membros (campos, métodos e construtores),
     * seleccionados no
     * ficheiro (writer) PlantUml, sem considerar relações de herança, implementação
     * ou associações entre tipos através de campos
     */
    public  PlantUmlBuilder emmitTypes() {
        // TODO
        return null;
    }
    
    /**
     * Emite associações de herança entre as classes e/ou interfacesusando a sintaxe PlantUml
     * Ex: BinExpr <|-- Add
     * para indicar que Add deriva de BinExpr
     * Ex: Iterable <|-- Collection para indicar que a interface Collection
     * deriva da interface Iterable
     */
    public PlantUmlBuilder emmitInheritanceAssociations() {
        // TODO
        return null;
    }
    
    /**
     * Emite associações de implementação entre de interfaces, usando a sintaxe PlantUml
     * Ex: Expr <|.... BinExpr
     * para indicar que BinExpr implementa a interface
     */
    public PlantUmlBuilder emmitImplAssociations() {
        // TODO
        return null;
    }
    
    /**
     * Emite associações entre classes através dos seus campos, usando a sintaxe PlantUml
     * Ex:  BinExpr "1" o----- "1" Expr : left
     * para indicar que BinExpr agrega um Expr através do seu campo left
     * A implementação deste método é opcional
     */
    
    public PlantUmlBuilder emmitFieldAssociations() {
        // TODO OPTIONALLY
        return null;
    }
    
    /**
     * Indicação o início da emissão no writer/ficheiro indicado na construçã
     * da instância PlantUmlBuilder
     * A partir desta chamada já não podem ser efectuadas chamadas para
     * adicionar novos tipos ou definir filtros de membro ou de tipo
     * @return
     */
    public PlantUmlBuilder start() {
        // TODO
        return null;
    }
    
    /**
     * conclui a produção do ficheiro PlantUml
     */
    public void end() {
        // TODO
    }
}
