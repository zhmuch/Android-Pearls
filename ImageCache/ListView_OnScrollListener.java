mImageLoader = ImageLoader.getInstance(context);
mListView.setOnScrollListener(onScrollListener);

OnScrollListener onScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            switch (scrollState) {
                case OnScrollListener.SCROLL_STATE_FLING:   
                    mImageLoader.lock();
                    break;
                case OnScrollListener.SCROLL_STATE_IDLE:
                    mImageLoader.unlock();
                    break;
                case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                    mImageLoader.lock();
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem,
                int visibleItemCount, int totalItemCount) {
        }
    };
