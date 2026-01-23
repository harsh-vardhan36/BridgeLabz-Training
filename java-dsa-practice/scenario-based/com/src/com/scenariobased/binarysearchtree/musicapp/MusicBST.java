package com.scenariobased.binarysearchtree.musicapp;

public class MusicBST {
    SongNode root;

    // Insert by song title (alphabetical order)
    public void insert(int trackId, String title, String artist) {
        root = insertRec(root, trackId, title, artist);
    }

    private SongNode insertRec(SongNode root, int trackId, String title, String artist) {
        if (root == null)
            return new SongNode(trackId, title, artist);

        if (title.compareToIgnoreCase(root.title) < 0)
            root.left = insertRec(root.left, trackId, title, artist);
        else
            root.right = insertRec(root.right, trackId, title, artist);

        return root;
    }

    // Search by Track ID (DFS)
    public SongNode searchByTrackId(int trackId) {
        return searchRec(root, trackId);
    }

    private SongNode searchRec(SongNode root, int trackId) {
        if (root == null) return null;

        if (root.trackId == trackId)
            return root;

        SongNode leftResult = searchRec(root.left, trackId);
        if (leftResult != null) return leftResult;

        return searchRec(root.right, trackId);
    }

    // Inorder traversal = Alphabetical playlist
    public void inorderPlaylist() {
        inorderRec(root);
    }

    private void inorderRec(SongNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.title + " - " + root.artist +
                               " (ID: " + root.trackId + ")");
            inorderRec(root.right);
        }
    }
}
