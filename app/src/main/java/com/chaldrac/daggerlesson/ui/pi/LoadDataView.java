package com.chaldrac.daggerlesson.ui.pi;

/**
 * Interface representing a View that will use to load data.
 */
public interface LoadDataView {

    /**
     * Show a view with empty data text
     */
    void showEmptyMessage();

    /**
     * Hide empty data text view
     */
    void hideEmptyMessage();

    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry();

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hideRetry();
}
