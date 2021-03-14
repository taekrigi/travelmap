import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import PostList from '../components/post/PostList'
import { getPosts } from '../actions/postAction'

const PostScreen = () => {
  const dispatch = useDispatch()
  const postState = useSelector((state) => state.post)

  const { postList, error } = postState

  useEffect(() => {
    dispatch(getPosts())
  }, [])

  return (
    <>
      {error ? (
        <>
          <Link to='/post/add'>글쓰기</Link>
          {error}
        </>
      ) : (
        <>
          <Link to='/post/add'>글쓰기</Link>
          <PostList postList={postList} />
        </>
      )}
    </>
  )
}

export default PostScreen
