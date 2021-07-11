package com.AAAD.Beroepsproduct3.SmartBrabant.Model;

import com.AAAD.Beroepsproduct3.SmartBrabant.View.View;
import org.geotools.ows.ServiceException;
import org.opengis.referencing.FactoryException;


import java.io.IOException;

/**
 * Created by Jochen Saalfeld <jochen.saalfeld@intevation.de> on 2/16/17.
 */
public class Controller {

    private DataBean dataBean;
    private View view;

    public Controller(DataBean dataBean) throws ServiceException,
            IOException, FactoryException {
        this.dataBean = dataBean;
        this.view = new View();
    }

    public void show() {
        view.show(dataBean.getPrimaryStage());
    }

}
