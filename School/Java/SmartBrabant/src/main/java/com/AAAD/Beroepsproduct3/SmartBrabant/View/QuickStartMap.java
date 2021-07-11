package com.AAAD.Beroepsproduct3.SmartBrabant.View;

import java.awt.Component;
import java.awt.event.ActionEvent;

/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2019, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 */

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.action.SafeAction;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.opengis.feature.Feature;
import org.opengis.feature.FeatureVisitor;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.geometry.Geometry;
import org.opengis.util.ProgressListener;

/**
 * Prompts the user for a shapefile and displays the contents on the screen in a map frame.
 *
 * <p>This is the GeoTools Quickstart application used in documentationa and tutorials. *
 */
public class QuickStartMap 
{
    /**
     * GeoTools Quickstart demo application. Prompts the user for a shapefile and displays its
     * contents on the screen in a map frame
     */
    private File sourceFile;
    private SimpleFeatureSource featureSource;
    private MapContent map;
    
    public static void main(String[] args) throws Exception {
    	

    	
        //display a data store file chooser dialog for shapefiles
//        File file = JFileDataStoreChooser.showOpenFile("shp", null);
//        
//        if (file == null) {
//            return;
//        }
        
    	QuickStartMap geoMap = new QuickStartMap();
    	geoMap.displayShapefile();
    	
//        // Create a map content and add our shapefile to it
//        MapContent map = new MapContent();
//        map.setTitle("Quickstart");
//
//        Style style = SLD.createSimpleStyle(featureSource.getSchema());
//        Layer layer = new FeatureLayer(featureSource, style);
//        map.addLayer(layer);
//        
//        // Create a JMapFrame with custom toolbar buttons
//        JMapFrame mapFrame = new JMapFrame(map);
//        mapFrame.enableToolBar(true);
//        mapFrame.enableStatusBar(true);
//
//        JToolBar toolbar = mapFrame.getToolBar();
//        toolbar.addSeparator();
//        toolbar.add(new JButton(new ValidateGeometryAction()));
//        toolbar.add(new JButton(new ExportShapefileAction()));
//
//        // Now display the map
//        JMapFrame.showMap(map);
    }
    
    private void displayShapefile() throws Exception {
//        sourceFile = JFileDataStoreChooser.showOpenFile("shp", null);
//        if (sourceFile == null) {
//            return;
//        }
        Map<String, Object> params = new HashMap<>();
        params.put("url", new URL("file", "", -1, "/H:/Avans/Ad-Informatica/Beroepsproduct%203/1a%20Werkomgeving/DTB_1_WEG_PS.shp")); //file.toURI().toURL() //"H:\\Avans\\Ad-Informatica\\Beroepsproduct 3\\1a Werkomgeving\\DTB_1_WEG_PS.shp" //"/H:/Avans/Ad-Informatica/Beroepsproduct%203/1a%20Werkomgeving/DTB_1_WEG_PS.shp"
        params.put("create spatial index", false);
        params.put("memory mapped buffer", false);
        params.put("charset", "ISO-8859-1");

        DataStore store = DataStoreFinder.getDataStore(params);
        SimpleFeatureSource featureSource = store.getFeatureSource(store.getTypeNames()[0]);
        
        // Create a map context and add our shapefile to it
        map = new MapContent();
        map.setTitle("Quickstart");
        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.layers().add(layer);

        // Create a JMapFrame with custom toolbar buttons
        JMapFrame mapFrame = new JMapFrame(map);
        mapFrame.enableToolBar(true);
        mapFrame.enableStatusBar(true);

        JToolBar toolbar = mapFrame.getToolBar();
        toolbar.addSeparator();
        //toolbar.add(new JButton(new ValidateGeometryAction()));
        //toolbar.add(new JButton(new ExportShapefileAction()));

        // Display the map frame. When it is closed the application will exit
        mapFrame.setSize(800, 600);
        mapFrame.setVisible(true);
    }
    
    class ValidateGeometryAction extends SafeAction {
        ValidateGeometryAction() {
            super("Validate geometry");
            putValue(Action.SHORT_DESCRIPTION, "Check each geometry");
        }

        public void action(ActionEvent e) throws Throwable {
            int numInvalid = validateFeatureGeometry(null);
            String msg;
            if (numInvalid == 0) {
                msg = "All feature geometries are valid";
            } else {
                msg = "Invalid geometries: " + numInvalid;
            }
            JOptionPane.showMessageDialog(
                    null, msg, "Geometry results", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private int validateFeatureGeometry(ProgressListener progress) throws Exception {
        final SimpleFeatureCollection featureCollection = featureSource.getFeatures();

        // Rather than use an iterator, create a FeatureVisitor to check each fature
        class ValidationVisitor implements FeatureVisitor {
            public int numInvalidGeometries = 0;

            public void visit(Feature f) {
                SimpleFeature feature = (SimpleFeature) f;
                Geometry geom = (Geometry) feature.getDefaultGeometry();
                if (geom != null && !((Component) geom).isValid()) {
                    numInvalidGeometries++;
                    System.out.println("Invalid Geoemtry: " + feature.getID());
                }
            }
        }

        ValidationVisitor visitor = new ValidationVisitor();

        // Pass visitor and the progress bar to feature collection
        featureCollection.accepts(visitor, progress);
        return visitor.numInvalidGeometries;
    }
}
