import React from 'react'
import Post from './Post'

const PostList = ({ postList }) => {
  return postList.map((post) => <Post key={post.id} post={post} />)
}

export default PostList
