@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_item, null);
        holder = new ViewHolder();
        holder.text = (TextView) convertView.findViewById(R.id.text);
        holder.image = (ImageView) convertView.findViewById(R.id.img);
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }
    ListItem item = mItems.get(position); //ListView的Item
    holder.text.setText(item.getText());
    holder.image.setImageResource(R.drawable.default_img); //设置默认图片
    mImageLoader.addTask(item.getImgUrl(), holder.image); //添加任务
    return convertView;
}

static class ViewHolder {
    TextView text;
    ImageView image;
}
