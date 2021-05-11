package com.ds.project.clientapp.service;

import com.ds.project.clientapp.beans.StFileUploadBeans;
import org.springframework.web.bind.annotation.PathVariable;

public interface StFileUploadProxy {

    public StFileUploadBeans retrieveFile(@PathVariable("from") String from, @PathVariable("to") String to);
}
