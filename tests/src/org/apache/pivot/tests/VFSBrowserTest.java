/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pivot.tests;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Frame;
import org.apache.pivot.wtk.ListView;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.PushButton;
import org.apache.pivot.wtk.Sheet;
import org.apache.pivot.wtk.SheetCloseListener;
import org.apache.pivot.wtk.VFSBrowserSheet;

public class VFSBrowserTest extends Application.Adapter {

    public VFSBrowserTest() {
    }

    private Frame frame = null;

    @Override
    public void startup(Display display, Map<String, String> properties) throws Exception {
        BoxPane windowContent = new BoxPane();
        PushButton button = new PushButton("Open Sheet");
        button.getButtonPressListeners().add(new ButtonPressListener() {
            @Override
            public void buttonPressed(Button buttonArgument) {
                try {
                    final VFSBrowserSheet vfsBrowserSheet = new VFSBrowserSheet(
                        VFSBrowserSheet.Mode.OPEN);

                    vfsBrowserSheet.open(frame, new SheetCloseListener() {
                        @Override
                        public void sheetClosed(Sheet sheet) {
                            if (sheet.getResult()) {
                                Sequence<FileObject> selectedFiles = vfsBrowserSheet.getSelectedFiles();

                                ListView listView = new ListView();
                                listView.setListData(new ArrayList<>(selectedFiles));
                                listView.setSelectMode(ListView.SelectMode.NONE);
                                listView.getStyles().put("backgroundColor", null);

                                Alert.alert(MessageType.INFO, "You selected:", listView, frame);
                            } else {
                                Alert.alert(MessageType.INFO, "You didn't select anything.", frame);
                            }
                        }
                    });
                } catch (FileSystemException fse) {
                    Alert.alert(MessageType.ERROR,
                        String.format("File System Exception: %1$s", fse.getMessage()), frame);
                }
            }
        });

        windowContent.add(button);

        frame = new Frame(windowContent);
        frame.setMaximized(true);
        frame.open(display);
    }

    @Override
    public boolean shutdown(boolean optional) {
        if (frame != null) {
            frame.close();
        }

        return false;
    }

    public static void main(String[] args) {
        DesktopApplicationContext.main(VFSBrowserTest.class, args);
    }

}
