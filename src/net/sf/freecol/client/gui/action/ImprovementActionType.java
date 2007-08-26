package net.sf.freecol.client.gui.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.freecol.FreeCol;
import net.sf.freecol.common.model.TileImprovementType;
import net.sf.freecol.common.util.Xml;

import org.w3c.dom.Node;

/**
 * A storage class for ImprovementActionType used to create ImprovementActions.
 * Filled by Specification.java, utilized by ActionManager.java
 */
public final class ImprovementActionType
{
    public static final  String  COPYRIGHT = "Copyright (C) 2003-2006 The FreeCol Team";

    public static final  String  LICENSE = "http://www.gnu.org/licenses/gpl.html";

    public static final  String  REVISION = "$Revision: 2889 $";

    public String ID;
    public char accelerator;
    
    public final List<String> names;
    public final List<TileImprovementType> impTypes;
    public final List<Integer> imageIDs;
    
    // ------------------------------------------------------------ constructors
    
    public ImprovementActionType() {
        names = new ArrayList<String>();
        impTypes = new ArrayList<TileImprovementType>();
        imageIDs = new ArrayList<Integer>();
    }

    // ------------------------------------------------------------ retrieval methods

    // ------------------------------------------------------------ API methods

    public void readFromXmlElement(Node xml, final Map<String, TileImprovementType> tileImprovementTypeByRef) {
        ID = Xml.attribute(xml, "id");
        accelerator = Xml.charAttribute(xml, "accelerator");

        Xml.Method method = new Xml.Method() {
            public void invokeOn(Node xml) {
                names.add(Xml.attribute(xml, "name"));
                String t = Xml.attribute(xml, "tileimprovement-type");
                impTypes.add(tileImprovementTypeByRef.get(t));
                imageIDs.add(Xml.intAttribute(xml, "image-id"));
            }
        };
        Xml.forEachChild(xml, method);
    }   
}
