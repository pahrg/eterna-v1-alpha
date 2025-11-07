package org.roda.wui.api.controllers;

import java.util.Map;

import org.roda.core.RodaCoreFactory;
import org.roda.core.data.exceptions.GenericException;
import org.roda.core.storage.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiskController {

  // @GetMapping("/diskstats")
  // public Map<String, Object> getDiskStats() throws GenericException,
  // ClassNotFoundException {
  //
  // StorageService storageService = RodaCoreFactory.getStorageService();
  //
  // if (storageService instanceof StorageServiceWrapper wrapper) {
  // StorageService underlying = wrapper.getWrappedStorageService();
  //
  // if (underlying instanceof FileStorageService fileStorage) {
  //
  // // now you can call your non-static method that uses basePath
  // return fileStorage.getStorageStats();
  //
  // }
  // }
  // return null;
  // }
  @GetMapping("/diskstats")
  public Map<String, Object> getDiskStats() throws GenericException {
    StorageService storageService = RodaCoreFactory.getStorageService();
    return storageService.getStorageStats();
  }

}
