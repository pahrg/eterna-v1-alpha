package org.roda.wui.api.v2.services;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import org.roda.core.RodaCoreFactory;
import org.roda.core.data.exceptions.AuthorizationDeniedException;
import org.roda.core.data.exceptions.GenericException;
import org.roda.core.data.exceptions.RODAException;
import org.roda.core.data.v2.log.LogEntryState;
import org.roda.core.data.v2.user.User;
import org.roda.core.model.utils.UserUtility;
import org.roda.core.storage.StorageService;
import org.roda.wui.common.ControllerAssistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiskController {

  @GetMapping("/diskstats")
  public Map<String, Object> getDiskStats(HttpServletRequest request)
      throws GenericException, AuthorizationDeniedException {
    final ControllerAssistant controllerAssistant = new ControllerAssistant() {};

    User user = UserUtility.getUser(request);

    // check user permissions
    controllerAssistant.checkRoles(user);

    StorageService storageService = RodaCoreFactory.getStorageService();

    LogEntryState state = LogEntryState.SUCCESS;
    try {
      return storageService.getStorageStats();
    } catch (RODAException e) {
      state = LogEntryState.FAILURE;
      throw e;
    } finally {
      controllerAssistant.registerAction(user, state);
    }
  }

}
