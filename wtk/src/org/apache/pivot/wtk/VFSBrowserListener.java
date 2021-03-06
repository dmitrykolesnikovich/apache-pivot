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
package org.apache.pivot.wtk;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.pivot.collections.Sequence;
import org.apache.pivot.util.Filter;

/**
 * Commons VFS browser listener interface.
 */
public interface VFSBrowserListener {
    /**
     * Commons VFS browser listener adapter.
     */
    public static class Adapter implements VFSBrowserListener {
        @Override
        public void managerChanged(VFSBrowser fileBrowser, FileSystemManager previousManager) {
            // empty block
        }

        @Override
        public void rootDirectoryChanged(VFSBrowser fileBrowser, FileObject previousRootDirectory) {
            // empty block
        }

        @Override
        public void homeDirectoryChanged(VFSBrowser fileBrowser, FileObject previousHomeDirectory) {
            // empty block
        }

        @Override
        public void selectedFileAdded(VFSBrowser fileBrowser, FileObject file) {
            // empty block
        }

        @Override
        public void selectedFileRemoved(VFSBrowser fileBrowser, FileObject file) {
            // empty block
        }

        @Override
        public void selectedFilesChanged(VFSBrowser fileBrowser,
            Sequence<FileObject> previousSelectedFiles) {
            // empty block
        }

        @Override
        public void multiSelectChanged(VFSBrowser fileBrowser) {
            // empty block
        }

        @Override
        public void disabledFileFilterChanged(VFSBrowser fileBrowser,
            Filter<FileObject> previousDisabledFileFilter) {
            // empty block
        }
    }

    /**
     * Called when a file browser's FileSystemManager has changed, (such as when
     * a nested VirtualFileSystem is opened).
     *
     * @param fileBrowser
     * @param previousManager
     */
    public void managerChanged(VFSBrowser fileBrowser, FileSystemManager previousManager);

    /**
     * Called when a file browser's root directory has changed.
     *
     * @param fileBrowser
     * @param previousRootDirectory
     */
    public void rootDirectoryChanged(VFSBrowser fileBrowser, FileObject previousRootDirectory);

    /**
     * Called when a file browser's home directory has changed.
     *
     * @param fileBrowser
     * @param previousHomeDirectory
     */
    public void homeDirectoryChanged(VFSBrowser fileBrowser, FileObject previousHomeDirectory);

    /**
     * Called when a file has been added to a file browser's selection.
     *
     * @param fileBrowser
     * @param file
     */
    public void selectedFileAdded(VFSBrowser fileBrowser, FileObject file);

    /**
     * Called when a file has been removed from a file browser's selection.
     *
     * @param fileBrowser
     * @param file
     */
    public void selectedFileRemoved(VFSBrowser fileBrowser, FileObject file);

    /**
     * Called when a file browser's selection state has been reset.
     *
     * @param fileBrowser
     * @param previousSelectedFiles
     */
    public void selectedFilesChanged(VFSBrowser fileBrowser,
        Sequence<FileObject> previousSelectedFiles);

    /**
     * Called when a file browser's multi-select flag has changed.
     *
     * @param fileBrowser
     */
    public void multiSelectChanged(VFSBrowser fileBrowser);

    /**
     * Called when a file browser's file filter has changed.
     *
     * @param fileBrowser
     * @param previousDisabledFileFilter
     */
    public void disabledFileFilterChanged(VFSBrowser fileBrowser,
        Filter<FileObject> previousDisabledFileFilter);
}
