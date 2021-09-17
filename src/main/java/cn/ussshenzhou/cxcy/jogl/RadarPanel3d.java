package cn.ussshenzhou.cxcy.jogl;


import cn.ussshenzhou.cxcy.utils.LogManager;
import com.ardor3d.extension.model.obj.ObjGeometryStore;
import com.ardor3d.extension.model.obj.ObjImporter;
import com.ardor3d.framework.DisplaySettings;
import com.ardor3d.framework.jogl.CapsUtil;
import com.ardor3d.framework.jogl.JoglCanvasRenderer;
import com.ardor3d.framework.jogl.awt.JoglSwingCanvas;
import com.ardor3d.intersection.PickResults;
import com.ardor3d.math.Ray3;
import com.ardor3d.renderer.ContextManager;
import com.ardor3d.renderer.Renderer;
import com.ardor3d.scenegraph.Node;
import com.ardor3d.util.ContextGarbageCollector;
import com.ardor3d.util.GameTaskQueueManager;
import com.ardor3d.util.resource.RelativeResourceLocator;
import com.ardor3d.util.resource.ResourceLocatorTool;
import com.ardor3d.util.resource.SimpleResourceLocator;
import com.ardor3d.util.resource.StringResourceSource;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.awt.GLJPanel;

import java.awt.*;
import java.net.URISyntaxException;

/**
 * @author USS_Shenzhou
 */
public class RadarPanel3d extends GLJPanel {
    CJoglCanvasRenderer cJoglCanvasRenderer = new CJoglCanvasRenderer();
    DisplaySettings settings = new DisplaySettings(400, 300, 24, 0, 0, 16, 0, 0, false, false);
    JoglSwingCanvas canvas = new JoglSwingCanvas(settings, cJoglCanvasRenderer);

    public RadarPanel3d() throws GLException {
        this.init();
        this.add(canvas);
    }

    private void init() {
        ((CScene) (canvas.getCanvasRenderer().getScene())).root.attachChild(this.loadObj());
    }

    private Node loadObj() {
        final long time = System.currentTimeMillis();
        final ObjImporter importer = new ObjImporter();
        try {
            importer.setModelLocator(new SimpleResourceLocator(ResourceLocatorTool.getClassPathResource(RadarPanel3d.class, "")));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //try {
        //    importer.setTextureLocator(new SimpleResourceLocator(ResourceLocatorTool.getClassPathResource(
        //            RadarPanel3d.class, "com/ardor3d/example/media/models/obj/")));
        //} catch (final URISyntaxException ex) {
        //    ex.printStackTrace();
        //}
        final ObjGeometryStore storage = importer.load("resources/model/test2.obj");
        return storage.getScene();
        //this.attachChild(storage.getScene());
    }

    private class CJoglCanvasRenderer extends JoglCanvasRenderer {
        public CJoglCanvasRenderer() {
            super(new CScene());
        }

        public CJoglCanvasRenderer(com.ardor3d.framework.Scene scene) {
            super(scene);
        }

        public CJoglCanvasRenderer(com.ardor3d.framework.Scene scene, boolean useDebug, CapsUtil capsUtil, boolean contextDropAndReclaimOnDrawEnabled) {
            super(scene, useDebug, capsUtil, contextDropAndReclaimOnDrawEnabled);
        }

    }


    private class CScene implements com.ardor3d.framework.Scene {
        private final Node root = new Node("root");

        public CScene() {
        }

        public Node getRoot() {
            return this.root;
        }

        @Override
        public boolean renderUnto(Renderer renderer) {
            GameTaskQueueManager.getManager(ContextManager.getCurrentContext()).getQueue("render").execute(renderer);
            ContextGarbageCollector.doRuntimeCleanup(renderer);
            renderer.draw(this.root);
            return true;
        }

        @Override
        public PickResults doPick(Ray3 ray3) {
            return null;
        }
    }

    private class Layout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int height = parent.getHeight();
            if (canvas.isVisible()) {
                canvas.setBounds(0, 0, width, height);
            }
        }
    }
}
